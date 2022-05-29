package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.CategoriePermis;
import com.ird.faa.dao.CategoriePermisDao;
import com.ird.faa.service.chercheur.facade.CategoriePermisChercheurService;

import com.ird.faa.ws.rest.provided.vo.CategoriePermisVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CategoriePermisChercheurServiceImpl extends AbstractServiceImpl<CategoriePermis> implements CategoriePermisChercheurService {

@Autowired
private CategoriePermisDao categoriePermisDao;



@Autowired
private EntityManager entityManager;


@Override
public List<CategoriePermis> findAll(){
        return categoriePermisDao.findAll();
}
    @Override
    public CategoriePermis findByReference(String reference){
    if( reference==null) return null;
    return categoriePermisDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return categoriePermisDao.deleteByReference(reference);
    }
    @Override
    public CategoriePermis findByIdOrReference(CategoriePermis categoriePermis){
    CategoriePermis resultat=null;
    if(categoriePermis != null){
    if(StringUtil.isNotEmpty(categoriePermis.getId())){
    resultat= categoriePermisDao.getOne(categoriePermis.getId());
    }else if(StringUtil.isNotEmpty(categoriePermis.getReference())) {
    resultat= categoriePermisDao.findByReference(categoriePermis.getReference());
    }
    }
    return resultat;
    }

@Override
public CategoriePermis findById(Long id){
if(id==null) return null;
return categoriePermisDao.getOne(id);
}

@Override
public CategoriePermis findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(categoriePermisDao.findById(id).isPresent())  {
categoriePermisDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public CategoriePermis update(CategoriePermis categoriePermis){
CategoriePermis foundedCategoriePermis = findById(categoriePermis.getId());
if(foundedCategoriePermis==null) return null;
else{
return  categoriePermisDao.save(categoriePermis);
}
}

@Override
public CategoriePermis save (CategoriePermis categoriePermis){

    CategoriePermis result =null;
    CategoriePermis foundedCategoriePermis = findByReference(categoriePermis.getReference());
    if(foundedCategoriePermis == null){




    CategoriePermis savedCategoriePermis = categoriePermisDao.save(categoriePermis);

    result = savedCategoriePermis;
    }

    return result;
}

@Override
public List<CategoriePermis> save(List<CategoriePermis> categoriePermiss){
List<CategoriePermis> list = new ArrayList<>();
for(CategoriePermis categoriePermis: categoriePermiss){
list.add(save(categoriePermis));
}
return list;
}



@Override
@Transactional
public int delete(CategoriePermis categoriePermis){
    if(categoriePermis.getReference()==null) return -1;

    CategoriePermis foundedCategoriePermis = findByReference(categoriePermis.getReference());
    if(foundedCategoriePermis==null) return -1;
categoriePermisDao.delete(foundedCategoriePermis);
return 1;
}


public List<CategoriePermis> findByCriteria(CategoriePermisVo categoriePermisVo){

String query = "SELECT o FROM CategoriePermis o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",categoriePermisVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",categoriePermisVo.getReference());
            query += SearchUtil.addConstraint( "o", "libele","LIKE",categoriePermisVo.getLibele());
            query += SearchUtil.addConstraint( "o", "description","LIKE",categoriePermisVo.getDescription());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<CategoriePermis> categoriePermiss){
if(ListUtil.isNotEmpty(categoriePermiss)){
categoriePermiss.forEach(e->categoriePermisDao.delete(e));
}
}
@Override
public void update(List<CategoriePermis> categoriePermiss){
if(ListUtil.isNotEmpty(categoriePermiss)){
categoriePermiss.forEach(e->categoriePermisDao.save(e));
}
}





    }
