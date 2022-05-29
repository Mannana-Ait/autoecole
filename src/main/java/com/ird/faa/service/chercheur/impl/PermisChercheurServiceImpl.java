package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Permis;
        import com.ird.faa.bean.CategoriePermis;
import com.ird.faa.dao.PermisDao;
import com.ird.faa.service.chercheur.facade.PermisChercheurService;
        import com.ird.faa.service.chercheur.facade.CategoriePermisChercheurService;

import com.ird.faa.ws.rest.provided.vo.PermisVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PermisChercheurServiceImpl extends AbstractServiceImpl<Permis> implements PermisChercheurService {

@Autowired
private PermisDao permisDao;

        @Autowired
        private CategoriePermisChercheurService categoriePermisService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Permis> findAll(){
        return permisDao.findAll();
}

        @Override
        public List<Permis> findByCategoriePermisReference(String reference){
        return permisDao.findByCategoriePermisReference(reference);
        }

        @Override
        @Transactional
        public int deleteByCategoriePermisReference(String reference){
        return permisDao.deleteByCategoriePermisReference(reference);
        }

        @Override
        public List<Permis> findByCategoriePermisId(Long id){
        return permisDao.findByCategoriePermisId(id);
        }

        @Override
        @Transactional
        public int deleteByCategoriePermisId(Long id){
        return permisDao.deleteByCategoriePermisId(id);
        }

    @Override
    public Permis findByReference(String reference){
    if( reference==null) return null;
    return permisDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return permisDao.deleteByReference(reference);
    }
    @Override
    public Permis findByIdOrReference(Permis permis){
    Permis resultat=null;
    if(permis != null){
    if(StringUtil.isNotEmpty(permis.getId())){
    resultat= permisDao.getOne(permis.getId());
    }else if(StringUtil.isNotEmpty(permis.getReference())) {
    resultat= permisDao.findByReference(permis.getReference());
    }
    }
    return resultat;
    }

@Override
public Permis findById(Long id){
if(id==null) return null;
return permisDao.getOne(id);
}

@Override
public Permis findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(permisDao.findById(id).isPresent())  {
permisDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Permis update(Permis permis){
Permis foundedPermis = findById(permis.getId());
if(foundedPermis==null) return null;
else{
return  permisDao.save(permis);
}
}

@Override
public Permis save (Permis permis){

    Permis result =null;
    Permis foundedPermis = findByReference(permis.getReference());
    if(foundedPermis == null){



    findCategoriePermis(permis);

    Permis savedPermis = permisDao.save(permis);

    result = savedPermis;
    }

    return result;
}

@Override
public List<Permis> save(List<Permis> permiss){
List<Permis> list = new ArrayList<>();
for(Permis permis: permiss){
list.add(save(permis));
}
return list;
}



@Override
@Transactional
public int delete(Permis permis){
    if(permis.getReference()==null) return -1;

    Permis foundedPermis = findByReference(permis.getReference());
    if(foundedPermis==null) return -1;
permisDao.delete(foundedPermis);
return 1;
}


public List<Permis> findByCriteria(PermisVo permisVo){

String query = "SELECT o FROM Permis o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",permisVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",permisVo.getReference());
        query += SearchUtil.addConstraintDate( "o", "dateDelivre","=",permisVo.getDateDelivre());
            query += SearchUtil.addConstraint( "o", "numberPermis","=",permisVo.getNumberPermis());
            query += SearchUtil.addConstraint( "o", "nomDelivreur","LIKE",permisVo.getNomDelivreur());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDelivre",permisVo.getDateDelivreMin(),permisVo.getDateDelivreMax());
            query += SearchUtil.addConstraintMinMax("o","numberPermis",permisVo.getNumberPermisMin(),permisVo.getNumberPermisMax());
    if(permisVo.getCategoriePermisVo()!=null){
        query += SearchUtil.addConstraint( "o", "categoriePermis.id","=",permisVo.getCategoriePermisVo().getId());
            query += SearchUtil.addConstraint( "o", "categoriePermis.reference","LIKE",permisVo.getCategoriePermisVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findCategoriePermis(Permis permis){
        CategoriePermis loadedCategoriePermis =categoriePermisService.findByIdOrReference(permis.getCategoriePermis());

    if(loadedCategoriePermis==null ) {
    return;
    }
    permis.setCategoriePermis(loadedCategoriePermis);
    }

@Override
@Transactional
public void delete(List<Permis> permiss){
if(ListUtil.isNotEmpty(permiss)){
permiss.forEach(e->permisDao.delete(e));
}
}
@Override
public void update(List<Permis> permiss){
if(ListUtil.isNotEmpty(permiss)){
permiss.forEach(e->permisDao.save(e));
}
}





    }
