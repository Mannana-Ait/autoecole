package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.TypeAvis;
import com.ird.faa.ws.rest.provided.vo.TypeAvisVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeAvisChercheurService extends AbstractService<TypeAvis,Long,TypeAvisVo>{



    /**
    * find TypeAvis from database by reference (reference)
    * @param reference - reference of TypeAvis
    * @return the founded TypeAvis , If no TypeAvis were
    *         found in database return  null.
    */
    TypeAvis findByReference(String reference);

    /**
    * find TypeAvis from database by id (PK) or reference (reference)
    * @param id - id of TypeAvis
    * @param reference - reference of TypeAvis
    * @return the founded TypeAvis , If no TypeAvis were
    *         found in database return  null.
    */
    TypeAvis findByIdOrReference(TypeAvis typeAvis);


/**
    * delete TypeAvis from database
    * @param id - id of TypeAvis to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TypeAvis from database by reference (reference)
    *
    * @param reference - reference of TypeAvis to be deleted
    * @return 1 if TypeAvis deleted successfully
    */
    int deleteByReference(String reference);





}
