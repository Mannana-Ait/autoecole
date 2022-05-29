package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.EtatMessage;
import com.ird.faa.ws.rest.provided.vo.EtatMessageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatMessageAdminService extends AbstractService<EtatMessage,Long,EtatMessageVo>{



    /**
    * find EtatMessage from database by reference (reference)
    * @param reference - reference of EtatMessage
    * @return the founded EtatMessage , If no EtatMessage were
    *         found in database return  null.
    */
    EtatMessage findByReference(String reference);

    /**
    * find EtatMessage from database by id (PK) or reference (reference)
    * @param id - id of EtatMessage
    * @param reference - reference of EtatMessage
    * @return the founded EtatMessage , If no EtatMessage were
    *         found in database return  null.
    */
    EtatMessage findByIdOrReference(EtatMessage etatMessage);


/**
    * delete EtatMessage from database
    * @param id - id of EtatMessage to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatMessage from database by reference (reference)
    *
    * @param reference - reference of EtatMessage to be deleted
    * @return 1 if EtatMessage deleted successfully
    */
    int deleteByReference(String reference);





}
