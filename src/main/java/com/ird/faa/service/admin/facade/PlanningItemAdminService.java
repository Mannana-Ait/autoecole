package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.PlanningItem;
import com.ird.faa.ws.rest.provided.vo.PlanningItemVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PlanningItemAdminService extends AbstractService<PlanningItem,Long,PlanningItemVo>{





/**
    * delete PlanningItem from database
    * @param id - id of PlanningItem to be deleted
    *
    */
    int deleteById(Long id);


    List<PlanningItem> findByJourReference(String reference);

    int deleteByJourReference(String reference);

    List<PlanningItem> findByJourId(Long id);

    int deleteByJourId(Long id);

    int deleteByEcoleId(Long id);
    List<PlanningItem> findByEcoleId(Long id);



}
