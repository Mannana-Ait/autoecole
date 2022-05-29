package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypeAvis;
import com.ird.faa.dao.TypeAvisDao;
import com.ird.faa.service.chercheur.facade.TypeAvisChercheurService;

import com.ird.faa.ws.rest.provided.vo.TypeAvisVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeAvisChercheurServiceImpl extends AbstractServiceImpl<TypeAvis> implements TypeAvisChercheurService {

@Autowired
private TypeAvisDao typeAvisDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeAvis> findAll(){
        return typeAvisDao.findAll();
}
    @Override
    public TypeAvis findByReference(String reference){
    if( reference==null) return null;
    return typeAvisDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return typeAvisDao.deleteByReference(reference);
    }
    @Override
    public TypeAvis findByIdOrReference(TypeAvis typeAvis){
    TypeAvis resultat=null;
    if(typeAvis != null){
    if(StringUtil.isNotEmpty(typeAvis.getId())){
    resultat= typeAvisDao.getOne(typeAvis.getId());
    }else if(StringUtil.isNotEmpty(typeAvis.getReference())) {
    resultat= typeAvisDao.findByReference(typeAvis.getReference());
    }
    }
    return resultat;
    }

@Override
public TypeAvis findById(Long id){
if(id==null) return null;
return typeAvisDao.getOne(id);
}

@Override
public TypeAvis findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(typeAvisDao.findById(id).isPresent())  {
typeAvisDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeAvis update(TypeAvis typeAvis){
TypeAvis foundedTypeAvis = findById(typeAvis.getId());
if(foundedTypeAvis==null) return null;
else{
return  typeAvisDao.save(typeAvis);
}
}

@Override
public TypeAvis save (TypeAvis typeAvis){

    TypeAvis result =null;
    TypeAvis foundedTypeAvis = findByReference(typeAvis.getReference());
    if(foundedTypeAvis == null){




    TypeAvis savedTypeAvis = typeAvisDao.save(typeAvis);

    result = savedTypeAvis;
    }

    return result;
}

@Override
public List<TypeAvis> save(List<TypeAvis> typeAviss){
List<TypeAvis> list = new ArrayList<>();
for(TypeAvis typeAvis: typeAviss){
list.add(save(typeAvis));
}
return list;
}



@Override
@Transactional
public int delete(TypeAvis typeAvis){
    if(typeAvis.getReference()==null) return -1;

    TypeAvis foundedTypeAvis = findByReference(typeAvis.getReference());
    if(foundedTypeAvis==null) return -1;
typeAvisDao.delete(foundedTypeAvis);
return 1;
}


public List<TypeAvis> findByCriteria(TypeAvisVo typeAvisVo){

String query = "SELECT o FROM TypeAvis o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeAvisVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeAvisVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",typeAvisVo.getReference());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeAvis> typeAviss){
if(ListUtil.isNotEmpty(typeAviss)){
typeAviss.forEach(e->typeAvisDao.delete(e));
}
}
@Override
public void update(List<TypeAvis> typeAviss){
if(ListUtil.isNotEmpty(typeAviss)){
typeAviss.forEach(e->typeAvisDao.save(e));
}
}





    }
