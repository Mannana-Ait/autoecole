package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Marque;
import com.ird.faa.ws.rest.provided.vo.MarqueVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface MarqueChercheurService extends AbstractService<Marque,Long,MarqueVo>{



    /**
    * find Marque from database by reference (reference)
    * @param reference - reference of Marque
    * @return the founded Marque , If no Marque were
    *         found in database return  null.
    */
    Marque findByReference(String reference);

    /**
    * find Marque from database by id (PK) or reference (reference)
    * @param id - id of Marque
    * @param reference - reference of Marque
    * @return the founded Marque , If no Marque were
    *         found in database return  null.
    */
    Marque findByIdOrReference(Marque marque);


/**
    * delete Marque from database
    * @param id - id of Marque to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Marque from database by reference (reference)
    *
    * @param reference - reference of Marque to be deleted
    * @return 1 if Marque deleted successfully
    */
    int deleteByReference(String reference);





}
