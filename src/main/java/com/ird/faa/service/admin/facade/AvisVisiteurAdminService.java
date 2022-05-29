package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.AvisVisiteur;
import com.ird.faa.ws.rest.provided.vo.AvisVisiteurVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface AvisVisiteurAdminService extends AbstractService<AvisVisiteur,Long,AvisVisiteurVo>{



    /**
    * find AvisVisiteur from database by reference (reference)
    * @param reference - reference of AvisVisiteur
    * @return the founded AvisVisiteur , If no AvisVisiteur were
    *         found in database return  null.
    */
    AvisVisiteur findByReference(String reference);

    /**
    * find AvisVisiteur from database by id (PK) or reference (reference)
    * @param id - id of AvisVisiteur
    * @param reference - reference of AvisVisiteur
    * @return the founded AvisVisiteur , If no AvisVisiteur were
    *         found in database return  null.
    */
    AvisVisiteur findByIdOrReference(AvisVisiteur avisVisiteur);


/**
    * delete AvisVisiteur from database
    * @param id - id of AvisVisiteur to be deleted
    *
    */
    int deleteById(Long id);


    List<AvisVisiteur> findByTypeAvisReference(String reference);

    int deleteByTypeAvisReference(String reference);

    List<AvisVisiteur> findByTypeAvisId(Long id);

    int deleteByTypeAvisId(Long id);


    /**
    * delete AvisVisiteur from database by reference (reference)
    *
    * @param reference - reference of AvisVisiteur to be deleted
    * @return 1 if AvisVisiteur deleted successfully
    */
    int deleteByReference(String reference);





}
