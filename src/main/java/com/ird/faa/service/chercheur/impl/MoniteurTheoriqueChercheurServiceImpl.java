package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.MoniteurTheorique;
        import com.ird.faa.bean.Gender;
import com.ird.faa.dao.MoniteurTheoriqueDao;
import com.ird.faa.service.chercheur.facade.MoniteurTheoriqueChercheurService;
        import com.ird.faa.service.chercheur.facade.GenderChercheurService;

import com.ird.faa.ws.rest.provided.vo.MoniteurTheoriqueVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class MoniteurTheoriqueChercheurServiceImpl extends AbstractServiceImpl<MoniteurTheorique> implements MoniteurTheoriqueChercheurService {

@Autowired
private MoniteurTheoriqueDao moniteurTheoriqueDao;

        @Autowired
        private GenderChercheurService genderService ;


@Autowired
private EntityManager entityManager;


@Override
public List<MoniteurTheorique> findAll(){
        return moniteurTheoriqueDao.findAll();
}

        @Override
        public List<MoniteurTheorique> findByGenderReference(String reference){
        return moniteurTheoriqueDao.findByGenderReference(reference);
        }

        @Override
        @Transactional
        public int deleteByGenderReference(String reference){
        return moniteurTheoriqueDao.deleteByGenderReference(reference);
        }

        @Override
        public List<MoniteurTheorique> findByGenderId(Long id){
        return moniteurTheoriqueDao.findByGenderId(id);
        }

        @Override
        @Transactional
        public int deleteByGenderId(Long id){
        return moniteurTheoriqueDao.deleteByGenderId(id);
        }

    @Override
    public int deleteByEcoleId(Long id) {
        return 0;
    }

    @Override
    public List<MoniteurTheorique> findByEcoleId(Long id) {
        return null;
    }

    @Override
    public MoniteurTheorique findByReference(String reference){
    if( reference==null) return null;
    return moniteurTheoriqueDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return moniteurTheoriqueDao.deleteByReference(reference);
    }
    @Override
    public MoniteurTheorique findByIdOrReference(MoniteurTheorique moniteurTheorique){
    MoniteurTheorique resultat=null;
    if(moniteurTheorique != null){
    if(StringUtil.isNotEmpty(moniteurTheorique.getId())){
    resultat= moniteurTheoriqueDao.getOne(moniteurTheorique.getId());
    }else if(StringUtil.isNotEmpty(moniteurTheorique.getReference())) {
    resultat= moniteurTheoriqueDao.findByReference(moniteurTheorique.getReference());
    }
    }
    return resultat;
    }

@Override
public MoniteurTheorique findById(Long id){
if(id==null) return null;
return moniteurTheoriqueDao.getOne(id);
}

@Override
public MoniteurTheorique findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(moniteurTheoriqueDao.findById(id).isPresent())  {
moniteurTheoriqueDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public MoniteurTheorique update(MoniteurTheorique moniteurTheorique){
MoniteurTheorique foundedMoniteurTheorique = findById(moniteurTheorique.getId());
if(foundedMoniteurTheorique==null) return null;
else{
return  moniteurTheoriqueDao.save(moniteurTheorique);
}
}

@Override
public MoniteurTheorique save (MoniteurTheorique moniteurTheorique){

    MoniteurTheorique result =null;
    MoniteurTheorique foundedMoniteurTheorique = findByReference(moniteurTheorique.getReference());
    if(foundedMoniteurTheorique == null){



    findGender(moniteurTheorique);

    MoniteurTheorique savedMoniteurTheorique = moniteurTheoriqueDao.save(moniteurTheorique);

    result = savedMoniteurTheorique;
    }

    return result;
}

@Override
public List<MoniteurTheorique> save(List<MoniteurTheorique> moniteurTheoriques){
List<MoniteurTheorique> list = new ArrayList<>();
for(MoniteurTheorique moniteurTheorique: moniteurTheoriques){
list.add(save(moniteurTheorique));
}
return list;
}



@Override
@Transactional
public int delete(MoniteurTheorique moniteurTheorique){
    if(moniteurTheorique.getReference()==null) return -1;

    MoniteurTheorique foundedMoniteurTheorique = findByReference(moniteurTheorique.getReference());
    if(foundedMoniteurTheorique==null) return -1;
moniteurTheoriqueDao.delete(foundedMoniteurTheorique);
return 1;
}


public List<MoniteurTheorique> findByCriteria(MoniteurTheoriqueVo moniteurTheoriqueVo){

String query = "SELECT o FROM MoniteurTheorique o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",moniteurTheoriqueVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",moniteurTheoriqueVo.getReference());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",moniteurTheoriqueVo.getNom());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",moniteurTheoriqueVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "email","LIKE",moniteurTheoriqueVo.getEmail());
            query += SearchUtil.addConstraint( "o", "adress","LIKE",moniteurTheoriqueVo.getAdress());
            query += SearchUtil.addConstraint( "o", "phone","LIKE",moniteurTheoriqueVo.getPhone());
            query += SearchUtil.addConstraint( "o", "fix","LIKE",moniteurTheoriqueVo.getFix());
        query += SearchUtil.addConstraintDate( "o", "lieuNaissance","=",moniteurTheoriqueVo.getLieuNaissance());
        query += SearchUtil.addConstraintDate( "o", "dateNaissance","=",moniteurTheoriqueVo.getDateNaissance());
            query += SearchUtil.addConstraint( "o", "cin","LIKE",moniteurTheoriqueVo.getCin());
            query += SearchUtil.addConstraint( "o", "picture","LIKE",moniteurTheoriqueVo.getPicture());
            query += SearchUtil.addConstraintMinMaxDate("o","lieuNaissance",moniteurTheoriqueVo.getLieuNaissanceMin(),moniteurTheoriqueVo.getLieuNaissanceMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateNaissance",moniteurTheoriqueVo.getDateNaissanceMin(),moniteurTheoriqueVo.getDateNaissanceMax());
    if(moniteurTheoriqueVo.getGenderVo()!=null){
        query += SearchUtil.addConstraint( "o", "gender.id","=",moniteurTheoriqueVo.getGenderVo().getId());
            query += SearchUtil.addConstraint( "o", "gender.reference","LIKE",moniteurTheoriqueVo.getGenderVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findGender(MoniteurTheorique moniteurTheorique){
        Gender loadedGender =genderService.findByIdOrReference(moniteurTheorique.getGender());

    if(loadedGender==null ) {
    return;
    }
    moniteurTheorique.setGender(loadedGender);
    }

@Override
@Transactional
public void delete(List<MoniteurTheorique> moniteurTheoriques){
if(ListUtil.isNotEmpty(moniteurTheoriques)){
moniteurTheoriques.forEach(e->moniteurTheoriqueDao.delete(e));
}
}
@Override
public void update(List<MoniteurTheorique> moniteurTheoriques){
if(ListUtil.isNotEmpty(moniteurTheoriques)){
moniteurTheoriques.forEach(e->moniteurTheoriqueDao.save(e));
}
}





    }
