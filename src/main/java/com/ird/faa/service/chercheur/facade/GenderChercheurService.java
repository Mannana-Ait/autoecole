package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Gender;
import com.ird.faa.ws.rest.provided.vo.GenderVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface GenderChercheurService extends AbstractService<Gender,Long,GenderVo>{



    /**
    * find Gender from database by reference (reference)
    * @param reference - reference of Gender
    * @return the founded Gender , If no Gender were
    *         found in database return  null.
    */
    Gender findByReference(String reference);

    /**
    * find Gender from database by id (PK) or reference (reference)
    * @param id - id of Gender
    * @param reference - reference of Gender
    * @return the founded Gender , If no Gender were
    *         found in database return  null.
    */
    Gender findByIdOrReference(Gender gender);


/**
    * delete Gender from database
    * @param id - id of Gender to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Gender from database by reference (reference)
    *
    * @param reference - reference of Gender to be deleted
    * @return 1 if Gender deleted successfully
    */
    int deleteByReference(String reference);





}
