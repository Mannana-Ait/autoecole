package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Gender;
import com.ird.faa.dao.GenderDao;
import com.ird.faa.service.chercheur.facade.GenderChercheurService;

import com.ird.faa.ws.rest.provided.vo.GenderVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class GenderChercheurServiceImpl extends AbstractServiceImpl<Gender> implements GenderChercheurService {

@Autowired
private GenderDao genderDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Gender> findAll(){
        return genderDao.findAll();
}
    @Override
    public Gender findByReference(String reference){
    if( reference==null) return null;
    return genderDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return genderDao.deleteByReference(reference);
    }
    @Override
    public Gender findByIdOrReference(Gender gender){
    Gender resultat=null;
    if(gender != null){
    if(StringUtil.isNotEmpty(gender.getId())){
    resultat= genderDao.getOne(gender.getId());
    }else if(StringUtil.isNotEmpty(gender.getReference())) {
    resultat= genderDao.findByReference(gender.getReference());
    }
    }
    return resultat;
    }

@Override
public Gender findById(Long id){
if(id==null) return null;
return genderDao.getOne(id);
}

@Override
public Gender findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(genderDao.findById(id).isPresent())  {
genderDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Gender update(Gender gender){
Gender foundedGender = findById(gender.getId());
if(foundedGender==null) return null;
else{
return  genderDao.save(gender);
}
}

@Override
public Gender save (Gender gender){

    Gender result =null;
    Gender foundedGender = findByReference(gender.getReference());
    if(foundedGender == null){




    Gender savedGender = genderDao.save(gender);

    result = savedGender;
    }

    return result;
}

@Override
public List<Gender> save(List<Gender> genders){
List<Gender> list = new ArrayList<>();
for(Gender gender: genders){
list.add(save(gender));
}
return list;
}



@Override
@Transactional
public int delete(Gender gender){
    if(gender.getReference()==null) return -1;

    Gender foundedGender = findByReference(gender.getReference());
    if(foundedGender==null) return -1;
genderDao.delete(foundedGender);
return 1;
}


public List<Gender> findByCriteria(GenderVo genderVo){

String query = "SELECT o FROM Gender o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",genderVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",genderVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",genderVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Gender> genders){
if(ListUtil.isNotEmpty(genders)){
genders.forEach(e->genderDao.delete(e));
}
}
@Override
public void update(List<Gender> genders){
if(ListUtil.isNotEmpty(genders)){
genders.forEach(e->genderDao.save(e));
}
}





    }
