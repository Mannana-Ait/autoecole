package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.MoniteurPratique;
        import com.ird.faa.bean.Gender;
import com.ird.faa.dao.MoniteurPratiqueDao;
import com.ird.faa.service.chercheur.facade.MoniteurPratiqueChercheurService;
        import com.ird.faa.service.chercheur.facade.GenderChercheurService;

import com.ird.faa.ws.rest.provided.vo.MoniteurPratiqueVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class MoniteurPratiqueChercheurServiceImpl extends AbstractServiceImpl<MoniteurPratique> implements MoniteurPratiqueChercheurService {

@Autowired
private MoniteurPratiqueDao moniteurPratiqueDao;

        @Autowired
        private GenderChercheurService genderService ;


@Autowired
private EntityManager entityManager;


@Override
public List<MoniteurPratique> findAll(){
        return moniteurPratiqueDao.findAll();
}

        @Override
        public List<MoniteurPratique> findByGenderReference(String reference){
        return moniteurPratiqueDao.findByGenderReference(reference);
        }

        @Override
        @Transactional
        public int deleteByGenderReference(String reference){
        return moniteurPratiqueDao.deleteByGenderReference(reference);
        }

        @Override
        public List<MoniteurPratique> findByGenderId(Long id){
        return moniteurPratiqueDao.findByGenderId(id);
        }

        @Override
        @Transactional
        public int deleteByGenderId(Long id){
        return moniteurPratiqueDao.deleteByGenderId(id);
        }

    @Override
    public MoniteurPratique findByReference(String reference){
    if( reference==null) return null;
    return moniteurPratiqueDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return moniteurPratiqueDao.deleteByReference(reference);
    }

    @Override
    public int deleteByEcoleId(Long id) {
        return 0;
    }

    @Override
    public List<MoniteurPratique> findByEcoleId(Long id) {
        return null;
    }

    @Override
    public MoniteurPratique findByIdOrReference(MoniteurPratique moniteurPratique){
    MoniteurPratique resultat=null;
    if(moniteurPratique != null){
    if(StringUtil.isNotEmpty(moniteurPratique.getId())){
    resultat= moniteurPratiqueDao.getOne(moniteurPratique.getId());
    }else if(StringUtil.isNotEmpty(moniteurPratique.getReference())) {
    resultat= moniteurPratiqueDao.findByReference(moniteurPratique.getReference());
    }
    }
    return resultat;
    }

@Override
public MoniteurPratique findById(Long id){
if(id==null) return null;
return moniteurPratiqueDao.getOne(id);
}

@Override
public MoniteurPratique findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(moniteurPratiqueDao.findById(id).isPresent())  {
moniteurPratiqueDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public MoniteurPratique update(MoniteurPratique moniteurPratique){
MoniteurPratique foundedMoniteurPratique = findById(moniteurPratique.getId());
if(foundedMoniteurPratique==null) return null;
else{
return  moniteurPratiqueDao.save(moniteurPratique);
}
}

@Override
public MoniteurPratique save (MoniteurPratique moniteurPratique){

    MoniteurPratique result =null;
    MoniteurPratique foundedMoniteurPratique = findByReference(moniteurPratique.getReference());
    if(foundedMoniteurPratique == null){



    findGender(moniteurPratique);

    MoniteurPratique savedMoniteurPratique = moniteurPratiqueDao.save(moniteurPratique);

    result = savedMoniteurPratique;
    }

    return result;
}

@Override
public List<MoniteurPratique> save(List<MoniteurPratique> moniteurPratiques){
List<MoniteurPratique> list = new ArrayList<>();
for(MoniteurPratique moniteurPratique: moniteurPratiques){
list.add(save(moniteurPratique));
}
return list;
}



@Override
@Transactional
public int delete(MoniteurPratique moniteurPratique){
    if(moniteurPratique.getReference()==null) return -1;

    MoniteurPratique foundedMoniteurPratique = findByReference(moniteurPratique.getReference());
    if(foundedMoniteurPratique==null) return -1;
moniteurPratiqueDao.delete(foundedMoniteurPratique);
return 1;
}


public List<MoniteurPratique> findByCriteria(MoniteurPratiqueVo moniteurPratiqueVo){

String query = "SELECT o FROM MoniteurPratique o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",moniteurPratiqueVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",moniteurPratiqueVo.getReference());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",moniteurPratiqueVo.getNom());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",moniteurPratiqueVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "email","LIKE",moniteurPratiqueVo.getEmail());
            query += SearchUtil.addConstraint( "o", "adress","LIKE",moniteurPratiqueVo.getAdress());
            query += SearchUtil.addConstraint( "o", "phone","LIKE",moniteurPratiqueVo.getPhone());
            query += SearchUtil.addConstraint( "o", "fix","LIKE",moniteurPratiqueVo.getFix());
        query += SearchUtil.addConstraintDate( "o", "lieuNaissance","=",moniteurPratiqueVo.getLieuNaissance());
        query += SearchUtil.addConstraintDate( "o", "dateNaissance","=",moniteurPratiqueVo.getDateNaissance());
            query += SearchUtil.addConstraint( "o", "cin","LIKE",moniteurPratiqueVo.getCin());
            query += SearchUtil.addConstraint( "o", "picture","LIKE",moniteurPratiqueVo.getPicture());
            query += SearchUtil.addConstraintMinMaxDate("o","lieuNaissance",moniteurPratiqueVo.getLieuNaissanceMin(),moniteurPratiqueVo.getLieuNaissanceMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateNaissance",moniteurPratiqueVo.getDateNaissanceMin(),moniteurPratiqueVo.getDateNaissanceMax());
    if(moniteurPratiqueVo.getGenderVo()!=null){
        query += SearchUtil.addConstraint( "o", "gender.id","=",moniteurPratiqueVo.getGenderVo().getId());
            query += SearchUtil.addConstraint( "o", "gender.reference","LIKE",moniteurPratiqueVo.getGenderVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findGender(MoniteurPratique moniteurPratique){
        Gender loadedGender =genderService.findByIdOrReference(moniteurPratique.getGender());

    if(loadedGender==null ) {
    return;
    }
    moniteurPratique.setGender(loadedGender);
    }

@Override
@Transactional
public void delete(List<MoniteurPratique> moniteurPratiques){
if(ListUtil.isNotEmpty(moniteurPratiques)){
moniteurPratiques.forEach(e->moniteurPratiqueDao.delete(e));
}
}
@Override
public void update(List<MoniteurPratique> moniteurPratiques){
if(ListUtil.isNotEmpty(moniteurPratiques)){
moniteurPratiques.forEach(e->moniteurPratiqueDao.save(e));
}
}





    }
