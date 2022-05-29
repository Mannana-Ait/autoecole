package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Gerant;
import com.ird.faa.ws.rest.provided.vo.GerantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface GerantChercheurService extends AbstractService<Gerant,Long,GerantVo>{



    /**
    * find Gerant from database by reference (reference)
    * @param reference - reference of Gerant
    * @return the founded Gerant , If no Gerant were
    *         found in database return  null.
    */
    Gerant findByReference(String reference);

    /**
    * find Gerant from database by id (PK) or reference (reference)
    * @param id - id of Gerant
    * @param reference - reference of Gerant
    * @return the founded Gerant , If no Gerant were
    *         found in database return  null.
    */
    Gerant findByIdOrReference(Gerant gerant);


/**
    * delete Gerant from database
    * @param id - id of Gerant to be deleted
    *
    */
    int deleteById(Long id);


    List<Gerant> findByGenderReference(String reference);

    int deleteByGenderReference(String reference);

    List<Gerant> findByGenderId(Long id);

    int deleteByGenderId(Long id);


    /**
    * delete Gerant from database by reference (reference)
    *
    * @param reference - reference of Gerant to be deleted
    * @return 1 if Gerant deleted successfully
    */
    int deleteByReference(String reference);





}
