package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Vehicule;
        import com.ird.faa.bean.Marque;
        import com.ird.faa.bean.TypeVehicule;
        import com.ird.faa.bean.Ecole;
import com.ird.faa.dao.VehiculeDao;
import com.ird.faa.service.admin.facade.VehiculeAdminService;
        import com.ird.faa.service.admin.facade.EcoleAdminService;
        import com.ird.faa.service.admin.facade.MarqueAdminService;
        import com.ird.faa.service.admin.facade.TypeVehiculeAdminService;

import com.ird.faa.ws.rest.provided.vo.VehiculeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class VehiculeAdminServiceImpl extends AbstractServiceImpl<Vehicule> implements VehiculeAdminService {

@Autowired
private VehiculeDao vehiculeDao;

        @Autowired
        private EcoleAdminService ecoleService ;
        @Autowired
        private MarqueAdminService marqueService ;
        @Autowired
        private TypeVehiculeAdminService typeVehiculeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Vehicule> findAll(){
        return vehiculeDao.findAll();
}

        @Override
        public List<Vehicule> findByMarqueReference(String reference){
        return vehiculeDao.findByMarqueReference(reference);
        }

        @Override
        @Transactional
        public int deleteByMarqueReference(String reference){
        return vehiculeDao.deleteByMarqueReference(reference);
        }

        @Override
        public List<Vehicule> findByMarqueId(Long id){
        return vehiculeDao.findByMarqueId(id);
        }

        @Override
        @Transactional
        public int deleteByMarqueId(Long id){
        return vehiculeDao.deleteByMarqueId(id);
        }


        @Override
        public List<Vehicule> findByTypeVehiculeReference(String reference){
        return vehiculeDao.findByTypeVehiculeReference(reference);
        }

        @Override
        @Transactional
        public int deleteByTypeVehiculeReference(String reference){
        return vehiculeDao.deleteByTypeVehiculeReference(reference);
        }

        @Override
        public List<Vehicule> findByTypeVehiculeId(Long id){
        return vehiculeDao.findByTypeVehiculeId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeVehiculeId(Long id){
        return vehiculeDao.deleteByTypeVehiculeId(id);
        }


        @Override
        public List<Vehicule> findByEcoleReference(String reference){
        return vehiculeDao.findByEcoleReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEcoleReference(String reference){
        return vehiculeDao.deleteByEcoleReference(reference);
        }

        @Override
        public List<Vehicule> findByEcoleId(Long id){
        return vehiculeDao.findByEcoleId(id);
        }

        @Override
        @Transactional
        public int deleteByEcoleId(Long id){
        return vehiculeDao.deleteByEcoleId(id);
        }


@Override
public Vehicule findById(Long id){
if(id==null) return null;
return vehiculeDao.getOne(id);
}

@Override
public Vehicule findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(vehiculeDao.findById(id).isPresent())  {
vehiculeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Vehicule update(Vehicule vehicule){
Vehicule foundedVehicule = findById(vehicule.getId());
if(foundedVehicule==null) return null;
else{
return  vehiculeDao.save(vehicule);
}
}

@Override
public Vehicule save (Vehicule vehicule){



    findMarque(vehicule);
    findTypeVehicule(vehicule);
    findEcole(vehicule);

    return vehiculeDao.save(vehicule);


}

@Override
public List<Vehicule> save(List<Vehicule> vehicules){
List<Vehicule> list = new ArrayList<>();
for(Vehicule vehicule: vehicules){
list.add(save(vehicule));
}
return list;
}



@Override
@Transactional
public int delete(Vehicule vehicule){
    if(vehicule.getId()==null) return -1;
    Vehicule foundedVehicule = findById(vehicule.getId());
    if(foundedVehicule==null) return -1;
vehiculeDao.delete(foundedVehicule);
return 1;
}


public List<Vehicule> findByCriteria(VehiculeVo vehiculeVo){

String query = "SELECT o FROM Vehicule o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",vehiculeVo.getId());
            query += SearchUtil.addConstraint( "o", "matricule","LIKE",vehiculeVo.getMatricule());
        query += SearchUtil.addConstraintDate( "o", "dateAchatVehicule","=",vehiculeVo.getDateAchatVehicule());
            query += SearchUtil.addConstraint( "o", "imageUrl","LIKE",vehiculeVo.getImageUrl());
            query += SearchUtil.addConstraintMinMaxDate("o","dateAchatVehicule",vehiculeVo.getDateAchatVehiculeMin(),vehiculeVo.getDateAchatVehiculeMax());
    if(vehiculeVo.getMarqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "marque.id","=",vehiculeVo.getMarqueVo().getId());
            query += SearchUtil.addConstraint( "o", "marque.reference","LIKE",vehiculeVo.getMarqueVo().getReference());
    }

    if(vehiculeVo.getTypeVehiculeVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeVehicule.id","=",vehiculeVo.getTypeVehiculeVo().getId());
            query += SearchUtil.addConstraint( "o", "typeVehicule.reference","LIKE",vehiculeVo.getTypeVehiculeVo().getReference());
    }

    if(vehiculeVo.getEcoleVo()!=null){
        query += SearchUtil.addConstraint( "o", "ecole.id","=",vehiculeVo.getEcoleVo().getId());
            query += SearchUtil.addConstraint( "o", "ecole.reference","LIKE",vehiculeVo.getEcoleVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findMarque(Vehicule vehicule){
        Marque loadedMarque =marqueService.findByIdOrReference(vehicule.getMarque());

    if(loadedMarque==null ) {
    return;
    }
    vehicule.setMarque(loadedMarque);
    }
    private void findTypeVehicule(Vehicule vehicule){
        TypeVehicule loadedTypeVehicule =typeVehiculeService.findByIdOrReference(vehicule.getTypeVehicule());

    if(loadedTypeVehicule==null ) {
    return;
    }
    vehicule.setTypeVehicule(loadedTypeVehicule);
    }
    private void findEcole(Vehicule vehicule){
        Ecole loadedEcole =ecoleService.findByIdOrReference(vehicule.getEcole());

    if(loadedEcole==null ) {
    return;
    }
    vehicule.setEcole(loadedEcole);
    }

@Override
@Transactional
public void delete(List<Vehicule> vehicules){
if(ListUtil.isNotEmpty(vehicules)){
vehicules.forEach(e->vehiculeDao.delete(e));
}
}
@Override
public void update(List<Vehicule> vehicules){
if(ListUtil.isNotEmpty(vehicules)){
vehicules.forEach(e->vehiculeDao.save(e));
}
}





    }
