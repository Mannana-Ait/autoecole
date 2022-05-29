package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PlanningItem;
        import com.ird.faa.bean.Jour;
import com.ird.faa.dao.PlanningItemDao;
import com.ird.faa.service.admin.facade.PlanningItemAdminService;
        import com.ird.faa.service.admin.facade.JourAdminService;

import com.ird.faa.ws.rest.provided.vo.PlanningItemVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PlanningItemAdminServiceImpl extends AbstractServiceImpl<PlanningItem> implements PlanningItemAdminService {

@Autowired
private PlanningItemDao planningItemDao;

        @Autowired
        private JourAdminService jourService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PlanningItem> findAll(){
        return planningItemDao.findAll();
}

        @Override
        public List<PlanningItem> findByJourReference(String reference){
        return planningItemDao.findByJourReference(reference);
        }

        @Override
        @Transactional
        public int deleteByJourReference(String reference){
        return planningItemDao.deleteByJourReference(reference);
        }

        @Override
        public List<PlanningItem> findByJourId(Long id){
        return planningItemDao.findByJourId(id);
        }

        @Override
        @Transactional
        public int deleteByJourId(Long id){
        return planningItemDao.deleteByJourId(id);
        }

    @Override
    public int deleteByEcoleId(Long id) {
        return planningItemDao.deleteByEcoleId(id);
    }

    @Override
    public List<PlanningItem> findByEcoleId(Long id) {
        return planningItemDao.findByEcoleId(id);
    }


    @Override
public PlanningItem findById(Long id){
if(id==null) return null;
return planningItemDao.getOne(id);
}

@Override
public PlanningItem findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(planningItemDao.findById(id).isPresent())  {
planningItemDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PlanningItem update(PlanningItem planningItem){
PlanningItem foundedPlanningItem = findById(planningItem.getId());
if(foundedPlanningItem==null) return null;
else{
return  planningItemDao.save(planningItem);
}
}

@Override
public PlanningItem save (PlanningItem planningItem){



    findJour(planningItem);

    return planningItemDao.save(planningItem);


}

@Override
public List<PlanningItem> save(List<PlanningItem> planningItems){
List<PlanningItem> list = new ArrayList<>();
for(PlanningItem planningItem: planningItems){
list.add(save(planningItem));
}
return list;
}



@Override
@Transactional
public int delete(PlanningItem planningItem){
    if(planningItem.getId()==null) return -1;
    PlanningItem foundedPlanningItem = findById(planningItem.getId());
    if(foundedPlanningItem==null) return -1;
planningItemDao.delete(foundedPlanningItem);
return 1;
}


public List<PlanningItem> findByCriteria(PlanningItemVo planningItemVo){

String query = "SELECT o FROM PlanningItem o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",planningItemVo.getId());
        query += SearchUtil.addConstraintDate( "o", "dateOuverture","=",planningItemVo.getDateOuverture());
        query += SearchUtil.addConstraintDate( "o", "dateFermeture","=",planningItemVo.getDateFermeture());
            query += SearchUtil.addConstraintMinMaxDate("o","dateOuverture",planningItemVo.getDateOuvertureMin(),planningItemVo.getDateOuvertureMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateFermeture",planningItemVo.getDateFermetureMin(),planningItemVo.getDateFermetureMax());
    if(planningItemVo.getJourVo()!=null){
        query += SearchUtil.addConstraint( "o", "jour.id","=",planningItemVo.getJourVo().getId());
            query += SearchUtil.addConstraint( "o", "jour.reference","LIKE",planningItemVo.getJourVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findJour(PlanningItem planningItem){
        Jour loadedJour =jourService.findByIdOrReference(planningItem.getJour());

    if(loadedJour==null ) {
    return;
    }
    planningItem.setJour(loadedJour);
    }

@Override
@Transactional
public void delete(List<PlanningItem> planningItems){
if(ListUtil.isNotEmpty(planningItems)){
planningItems.forEach(e->planningItemDao.delete(e));
}
}
@Override
public void update(List<PlanningItem> planningItems){
if(ListUtil.isNotEmpty(planningItems)){
planningItems.forEach(e->planningItemDao.save(e));
}
}





    }
