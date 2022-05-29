package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.MoniteurPratique;
import com.ird.faa.bean.MoniteurTheorique;
import com.ird.faa.ws.rest.provided.vo.MoniteurPratiqueVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface MoniteurPratiqueChercheurService extends AbstractService<MoniteurPratique,Long,MoniteurPratiqueVo>{



    /**
    * find MoniteurPratique from database by reference (reference)
    * @param reference - reference of MoniteurPratique
    * @return the founded MoniteurPratique , If no MoniteurPratique were
    *         found in database return  null.
    */
    MoniteurPratique findByReference(String reference);

    /**
    * find MoniteurPratique from database by id (PK) or reference (reference)
    * @param id - id of MoniteurPratique
    * @param reference - reference of MoniteurPratique
    * @return the founded MoniteurPratique , If no MoniteurPratique were
    *         found in database return  null.
    */
    MoniteurPratique findByIdOrReference(MoniteurPratique moniteurPratique);


/**
    * delete MoniteurPratique from database
    * @param id - id of MoniteurPratique to be deleted
    *
    */
    int deleteById(Long id);


    List<MoniteurPratique> findByGenderReference(String reference);

    int deleteByGenderReference(String reference);

    List<MoniteurPratique> findByGenderId(Long id);

    int deleteByGenderId(Long id);


    /**
    * delete MoniteurPratique from database by reference (reference)
    *
    * @param reference - reference of MoniteurPratique to be deleted
    * @return 1 if MoniteurPratique deleted successfully
    */
    int deleteByReference(String reference);

    int deleteByEcoleId(Long id);
    List<MoniteurPratique> findByEcoleId(Long id);




}
