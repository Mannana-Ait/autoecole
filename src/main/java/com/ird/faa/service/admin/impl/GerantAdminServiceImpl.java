package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Gerant;
        import com.ird.faa.bean.Gender;
import com.ird.faa.dao.GerantDao;
import com.ird.faa.service.admin.facade.GerantAdminService;
        import com.ird.faa.service.admin.facade.GenderAdminService;

import com.ird.faa.ws.rest.provided.vo.GerantVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class GerantAdminServiceImpl extends AbstractServiceImpl<Gerant> implements GerantAdminService {

@Autowired
private GerantDao gerantDao;

        @Autowired
        private GenderAdminService genderService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Gerant> findAll(){
        return gerantDao.findAll();
}

        @Override
        public List<Gerant> findByGenderReference(String reference){
        return gerantDao.findByGenderReference(reference);
        }

        @Override
        @Transactional
        public int deleteByGenderReference(String reference){
        return gerantDao.deleteByGenderReference(reference);
        }

        @Override
        public List<Gerant> findByGenderId(Long id){
        return gerantDao.findByGenderId(id);
        }

        @Override
        @Transactional
        public int deleteByGenderId(Long id){
        return gerantDao.deleteByGenderId(id);
        }

    @Override
    public Gerant findByReference(String reference){
    if( reference==null) return null;
    return gerantDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return gerantDao.deleteByReference(reference);
    }
    @Override
    public Gerant findByIdOrReference(Gerant gerant){
    Gerant resultat=null;
    if(gerant != null){
    if(StringUtil.isNotEmpty(gerant.getId())){
    resultat= gerantDao.getOne(gerant.getId());
    }else if(StringUtil.isNotEmpty(gerant.getReference())) {
    resultat= gerantDao.findByReference(gerant.getReference());
    }
    }
    return resultat;
    }

@Override
public Gerant findById(Long id){
if(id==null) return null;
return gerantDao.getOne(id);
}

@Override
public Gerant findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(gerantDao.findById(id).isPresent())  {
gerantDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Gerant update(Gerant gerant){
Gerant foundedGerant = findById(gerant.getId());
if(foundedGerant==null) return null;
else{
return  gerantDao.save(gerant);
}
}

@Override
public Gerant save (Gerant gerant){

    Gerant result =null;
    Gerant foundedGerant = findByReference(gerant.getReference());
    if(foundedGerant == null){



    findGender(gerant);

    Gerant savedGerant = gerantDao.save(gerant);

    result = savedGerant;
    }

    return result;
}

@Override
public List<Gerant> save(List<Gerant> gerants){
List<Gerant> list = new ArrayList<>();
for(Gerant gerant: gerants){
list.add(save(gerant));
}
return list;
}



@Override
@Transactional
public int delete(Gerant gerant){
    if(gerant.getReference()==null) return -1;

    Gerant foundedGerant = findByReference(gerant.getReference());
    if(foundedGerant==null) return -1;
gerantDao.delete(foundedGerant);
return 1;
}


public List<Gerant> findByCriteria(GerantVo gerantVo){

String query = "SELECT o FROM Gerant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",gerantVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",gerantVo.getReference());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",gerantVo.getNom());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",gerantVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "email","LIKE",gerantVo.getEmail());
            query += SearchUtil.addConstraint( "o", "adress","LIKE",gerantVo.getAdress());
            query += SearchUtil.addConstraint( "o", "phone","LIKE",gerantVo.getPhone());
            query += SearchUtil.addConstraint( "o", "fix","LIKE",gerantVo.getFix());
            query += SearchUtil.addConstraint( "o", "lieuNaissance","LIKE",gerantVo.getLieuNaissance());
            query += SearchUtil.addConstraint( "o", "dateNaissance","LIKE",gerantVo.getDateNaissance());
            query += SearchUtil.addConstraint( "o", "cin","LIKE",gerantVo.getCin());
            query += SearchUtil.addConstraint( "o", "picture","LIKE",gerantVo.getPicture());
        query += SearchUtil.addConstraintDate( "o", "dateJoin","=",gerantVo.getDateJoin());
            query += SearchUtil.addConstraintMinMaxDate("o","dateJoin",gerantVo.getDateJoinMin(),gerantVo.getDateJoinMax());
    if(gerantVo.getGenderVo()!=null){
        query += SearchUtil.addConstraint( "o", "gender.id","=",gerantVo.getGenderVo().getId());
            query += SearchUtil.addConstraint( "o", "gender.reference","LIKE",gerantVo.getGenderVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findGender(Gerant gerant){
        Gender loadedGender =genderService.findByIdOrReference(gerant.getGender());

    if(loadedGender==null ) {
    return;
    }
    gerant.setGender(loadedGender);
    }

@Override
@Transactional
public void delete(List<Gerant> gerants){
if(ListUtil.isNotEmpty(gerants)){
gerants.forEach(e->gerantDao.delete(e));
}
}
@Override
public void update(List<Gerant> gerants){
if(ListUtil.isNotEmpty(gerants)){
gerants.forEach(e->gerantDao.save(e));
}
}





    }
