package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Jour;
import com.ird.faa.ws.rest.provided.vo.JourVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface JourChercheurService extends AbstractService<Jour,Long,JourVo>{



    /**
    * find Jour from database by reference (reference)
    * @param reference - reference of Jour
    * @return the founded Jour , If no Jour were
    *         found in database return  null.
    */
    Jour findByReference(String reference);

    /**
    * find Jour from database by id (PK) or reference (reference)
    * @param id - id of Jour
    * @param reference - reference of Jour
    * @return the founded Jour , If no Jour were
    *         found in database return  null.
    */
    Jour findByIdOrReference(Jour jour);


/**
    * delete Jour from database
    * @param id - id of Jour to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Jour from database by reference (reference)
    *
    * @param reference - reference of Jour to be deleted
    * @return 1 if Jour deleted successfully
    */
    int deleteByReference(String reference);





}
