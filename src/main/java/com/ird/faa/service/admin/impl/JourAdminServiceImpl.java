package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Jour;
import com.ird.faa.dao.JourDao;
import com.ird.faa.service.admin.facade.JourAdminService;

import com.ird.faa.ws.rest.provided.vo.JourVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class JourAdminServiceImpl extends AbstractServiceImpl<Jour> implements JourAdminService {

@Autowired
private JourDao jourDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Jour> findAll(){
        return jourDao.findAll();
}
    @Override
    public Jour findByReference(String reference){
    if( reference==null) return null;
    return jourDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return jourDao.deleteByReference(reference);
    }
    @Override
    public Jour findByIdOrReference(Jour jour){
    Jour resultat=null;
    if(jour != null){
    if(StringUtil.isNotEmpty(jour.getId())){
    resultat= jourDao.getOne(jour.getId());
    }else if(StringUtil.isNotEmpty(jour.getReference())) {
    resultat= jourDao.findByReference(jour.getReference());
    }
    }
    return resultat;
    }

@Override
public Jour findById(Long id){
if(id==null) return null;
return jourDao.getOne(id);
}

@Override
public Jour findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(jourDao.findById(id).isPresent())  {
jourDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Jour update(Jour jour){
Jour foundedJour = findById(jour.getId());
if(foundedJour==null) return null;
else{
return  jourDao.save(jour);
}
}

@Override
public Jour save (Jour jour){

    Jour result =null;
    Jour foundedJour = findByReference(jour.getReference());
    if(foundedJour == null){




    Jour savedJour = jourDao.save(jour);

    result = savedJour;
    }

    return result;
}

@Override
public List<Jour> save(List<Jour> jours){
List<Jour> list = new ArrayList<>();
for(Jour jour: jours){
list.add(save(jour));
}
return list;
}



@Override
@Transactional
public int delete(Jour jour){
    if(jour.getReference()==null) return -1;

    Jour foundedJour = findByReference(jour.getReference());
    if(foundedJour==null) return -1;
jourDao.delete(foundedJour);
return 1;
}


public List<Jour> findByCriteria(JourVo jourVo){

String query = "SELECT o FROM Jour o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",jourVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",jourVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",jourVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Jour> jours){
if(ListUtil.isNotEmpty(jours)){
jours.forEach(e->jourDao.delete(e));
}
}
@Override
public void update(List<Jour> jours){
if(ListUtil.isNotEmpty(jours)){
jours.forEach(e->jourDao.save(e));
}
}





    }
