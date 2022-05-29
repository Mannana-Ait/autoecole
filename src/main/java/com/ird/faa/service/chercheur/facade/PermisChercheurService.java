package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Permis;
import com.ird.faa.ws.rest.provided.vo.PermisVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PermisChercheurService extends AbstractService<Permis,Long,PermisVo>{



    /**
    * find Permis from database by reference (reference)
    * @param reference - reference of Permis
    * @return the founded Permis , If no Permis were
    *         found in database return  null.
    */
    Permis findByReference(String reference);

    /**
    * find Permis from database by id (PK) or reference (reference)
    * @param id - id of Permis
    * @param reference - reference of Permis
    * @return the founded Permis , If no Permis were
    *         found in database return  null.
    */
    Permis findByIdOrReference(Permis permis);


/**
    * delete Permis from database
    * @param id - id of Permis to be deleted
    *
    */
    int deleteById(Long id);


    List<Permis> findByCategoriePermisReference(String reference);

    int deleteByCategoriePermisReference(String reference);

    List<Permis> findByCategoriePermisId(Long id);

    int deleteByCategoriePermisId(Long id);


    /**
    * delete Permis from database by reference (reference)
    *
    * @param reference - reference of Permis to be deleted
    * @return 1 if Permis deleted successfully
    */
    int deleteByReference(String reference);





}
