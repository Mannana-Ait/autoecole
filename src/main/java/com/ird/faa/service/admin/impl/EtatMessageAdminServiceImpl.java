package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatMessage;
import com.ird.faa.dao.EtatMessageDao;
import com.ird.faa.service.admin.facade.EtatMessageAdminService;

import com.ird.faa.ws.rest.provided.vo.EtatMessageVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatMessageAdminServiceImpl extends AbstractServiceImpl<EtatMessage> implements EtatMessageAdminService {

@Autowired
private EtatMessageDao etatMessageDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatMessage> findAll(){
        return etatMessageDao.findAll();
}
    @Override
    public EtatMessage findByReference(String reference){
    if( reference==null) return null;
    return etatMessageDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return etatMessageDao.deleteByReference(reference);
    }
    @Override
    public EtatMessage findByIdOrReference(EtatMessage etatMessage){
    EtatMessage resultat=null;
    if(etatMessage != null){
    if(StringUtil.isNotEmpty(etatMessage.getId())){
    resultat= etatMessageDao.getOne(etatMessage.getId());
    }else if(StringUtil.isNotEmpty(etatMessage.getReference())) {
    resultat= etatMessageDao.findByReference(etatMessage.getReference());
    }
    }
    return resultat;
    }

@Override
public EtatMessage findById(Long id){
if(id==null) return null;
return etatMessageDao.getOne(id);
}

@Override
public EtatMessage findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(etatMessageDao.findById(id).isPresent())  {
etatMessageDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatMessage update(EtatMessage etatMessage){
EtatMessage foundedEtatMessage = findById(etatMessage.getId());
if(foundedEtatMessage==null) return null;
else{
return  etatMessageDao.save(etatMessage);
}
}

@Override
public EtatMessage save (EtatMessage etatMessage){

    EtatMessage result =null;
    EtatMessage foundedEtatMessage = findByReference(etatMessage.getReference());
    if(foundedEtatMessage == null){




    EtatMessage savedEtatMessage = etatMessageDao.save(etatMessage);

    result = savedEtatMessage;
    }

    return result;
}

@Override
public List<EtatMessage> save(List<EtatMessage> etatMessages){
List<EtatMessage> list = new ArrayList<>();
for(EtatMessage etatMessage: etatMessages){
list.add(save(etatMessage));
}
return list;
}



@Override
@Transactional
public int delete(EtatMessage etatMessage){
    if(etatMessage.getReference()==null) return -1;

    EtatMessage foundedEtatMessage = findByReference(etatMessage.getReference());
    if(foundedEtatMessage==null) return -1;
etatMessageDao.delete(foundedEtatMessage);
return 1;
}


public List<EtatMessage> findByCriteria(EtatMessageVo etatMessageVo){

String query = "SELECT o FROM EtatMessage o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatMessageVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",etatMessageVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatMessageVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatMessage> etatMessages){
if(ListUtil.isNotEmpty(etatMessages)){
etatMessages.forEach(e->etatMessageDao.delete(e));
}
}
@Override
public void update(List<EtatMessage> etatMessages){
if(ListUtil.isNotEmpty(etatMessages)){
etatMessages.forEach(e->etatMessageDao.save(e));
}
}





    }
