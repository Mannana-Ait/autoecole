package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.AvisVisiteur;
        import com.ird.faa.bean.TypeAvis;
import com.ird.faa.dao.AvisVisiteurDao;
import com.ird.faa.service.chercheur.facade.AvisVisiteurChercheurService;
        import com.ird.faa.service.chercheur.facade.TypeAvisChercheurService;

import com.ird.faa.ws.rest.provided.vo.AvisVisiteurVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class AvisVisiteurChercheurServiceImpl extends AbstractServiceImpl<AvisVisiteur> implements AvisVisiteurChercheurService {

@Autowired
private AvisVisiteurDao avisVisiteurDao;

        @Autowired
        private TypeAvisChercheurService typeAvisService ;


@Autowired
private EntityManager entityManager;


@Override
public List<AvisVisiteur> findAll(){
        return avisVisiteurDao.findAll();
}

        @Override
        public List<AvisVisiteur> findByTypeAvisReference(String reference){
        return avisVisiteurDao.findByTypeAvisReference(reference);
        }

        @Override
        @Transactional
        public int deleteByTypeAvisReference(String reference){
        return avisVisiteurDao.deleteByTypeAvisReference(reference);
        }

        @Override
        public List<AvisVisiteur> findByTypeAvisId(Long id){
        return avisVisiteurDao.findByTypeAvisId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeAvisId(Long id){
        return avisVisiteurDao.deleteByTypeAvisId(id);
        }

    @Override
    public AvisVisiteur findByReference(String reference){
    if( reference==null) return null;
    return avisVisiteurDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return avisVisiteurDao.deleteByReference(reference);
    }
    @Override
    public AvisVisiteur findByIdOrReference(AvisVisiteur avisVisiteur){
    AvisVisiteur resultat=null;
    if(avisVisiteur != null){
    if(StringUtil.isNotEmpty(avisVisiteur.getId())){
    resultat= avisVisiteurDao.getOne(avisVisiteur.getId());
    }else if(StringUtil.isNotEmpty(avisVisiteur.getReference())) {
    resultat= avisVisiteurDao.findByReference(avisVisiteur.getReference());
    }
    }
    return resultat;
    }

@Override
public AvisVisiteur findById(Long id){
if(id==null) return null;
return avisVisiteurDao.getOne(id);
}

@Override
public AvisVisiteur findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(avisVisiteurDao.findById(id).isPresent())  {
avisVisiteurDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public AvisVisiteur update(AvisVisiteur avisVisiteur){
AvisVisiteur foundedAvisVisiteur = findById(avisVisiteur.getId());
if(foundedAvisVisiteur==null) return null;
else{
return  avisVisiteurDao.save(avisVisiteur);
}
}

@Override
public AvisVisiteur save (AvisVisiteur avisVisiteur){

    AvisVisiteur result =null;
    AvisVisiteur foundedAvisVisiteur = findByReference(avisVisiteur.getReference());
    if(foundedAvisVisiteur == null){



    findTypeAvis(avisVisiteur);

    AvisVisiteur savedAvisVisiteur = avisVisiteurDao.save(avisVisiteur);

    result = savedAvisVisiteur;
    }

    return result;
}

@Override
public List<AvisVisiteur> save(List<AvisVisiteur> avisVisiteurs){
List<AvisVisiteur> list = new ArrayList<>();
for(AvisVisiteur avisVisiteur: avisVisiteurs){
list.add(save(avisVisiteur));
}
return list;
}



@Override
@Transactional
public int delete(AvisVisiteur avisVisiteur){
    if(avisVisiteur.getReference()==null) return -1;

    AvisVisiteur foundedAvisVisiteur = findByReference(avisVisiteur.getReference());
    if(foundedAvisVisiteur==null) return -1;
avisVisiteurDao.delete(foundedAvisVisiteur);
return 1;
}


public List<AvisVisiteur> findByCriteria(AvisVisiteurVo avisVisiteurVo){

String query = "SELECT o FROM AvisVisiteur o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",avisVisiteurVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",avisVisiteurVo.getReference());
            query += SearchUtil.addConstraint( "o", "emailVisiteur","LIKE",avisVisiteurVo.getEmailVisiteur());
            query += SearchUtil.addConstraint( "o", "objet","LIKE",avisVisiteurVo.getObjet());
            query += SearchUtil.addConstraint( "o", "message","LIKE",avisVisiteurVo.getMessage());
            query += SearchUtil.addConstraint( "o", "ratting","=",avisVisiteurVo.getRatting());
            query += SearchUtil.addConstraintMinMax("o","ratting",avisVisiteurVo.getRattingMin(),avisVisiteurVo.getRattingMax());
    if(avisVisiteurVo.getTypeAvisVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeAvis.id","=",avisVisiteurVo.getTypeAvisVo().getId());
            query += SearchUtil.addConstraint( "o", "typeAvis.reference","LIKE",avisVisiteurVo.getTypeAvisVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findTypeAvis(AvisVisiteur avisVisiteur){
        TypeAvis loadedTypeAvis =typeAvisService.findByIdOrReference(avisVisiteur.getTypeAvis());

    if(loadedTypeAvis==null ) {
    return;
    }
    avisVisiteur.setTypeAvis(loadedTypeAvis);
    }

@Override
@Transactional
public void delete(List<AvisVisiteur> avisVisiteurs){
if(ListUtil.isNotEmpty(avisVisiteurs)){
avisVisiteurs.forEach(e->avisVisiteurDao.delete(e));
}
}
@Override
public void update(List<AvisVisiteur> avisVisiteurs){
if(ListUtil.isNotEmpty(avisVisiteurs)){
avisVisiteurs.forEach(e->avisVisiteurDao.save(e));
}
}





    }
