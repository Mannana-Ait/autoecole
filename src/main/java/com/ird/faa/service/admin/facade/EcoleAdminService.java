package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Ecole;
import com.ird.faa.ws.rest.provided.vo.EcoleVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EcoleAdminService extends AbstractService<Ecole,Long,EcoleVo>{



    /**
    * find Ecole from database by reference (reference)
    * @param reference - reference of Ecole
    * @return the founded Ecole , If no Ecole were
    *         found in database return  null.
    */
    Ecole findByReference(String reference);

    /**
    * find Ecole from database by id (PK) or reference (reference)
    * @param id - id of Ecole
    * @param reference - reference of Ecole
    * @return the founded Ecole , If no Ecole were
    *         found in database return  null.
    */
    Ecole findByIdOrReference(Ecole ecole);


/**
    * delete Ecole from database
    * @param id - id of Ecole to be deleted
    *
    */
    int deleteById(Long id);

    List<Ecole> findByVilleReference(String reference);

    int deleteByVilleReference(String reference);

    List<Ecole> findByVilleId(Long id);

    int deleteByVilleId(Long id);
    List<Ecole> findByGerantReference(String reference);

    int deleteByGerantReference(String reference);

    List<Ecole> findByGerantId(Long id);

    int deleteByGerantId(Long id);


    /**
    * delete Ecole from database by reference (reference)
    *
    * @param reference - reference of Ecole to be deleted
    * @return 1 if Ecole deleted successfully
    */
    int deleteByReference(String reference);





}
