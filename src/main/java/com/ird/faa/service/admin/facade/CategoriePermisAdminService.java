package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.CategoriePermis;
import com.ird.faa.ws.rest.provided.vo.CategoriePermisVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CategoriePermisAdminService extends AbstractService<CategoriePermis,Long,CategoriePermisVo>{



    /**
    * find CategoriePermis from database by reference (reference)
    * @param reference - reference of CategoriePermis
    * @return the founded CategoriePermis , If no CategoriePermis were
    *         found in database return  null.
    */
    CategoriePermis findByReference(String reference);

    /**
    * find CategoriePermis from database by id (PK) or reference (reference)
    * @param id - id of CategoriePermis
    * @param reference - reference of CategoriePermis
    * @return the founded CategoriePermis , If no CategoriePermis were
    *         found in database return  null.
    */
    CategoriePermis findByIdOrReference(CategoriePermis categoriePermis);


/**
    * delete CategoriePermis from database
    * @param id - id of CategoriePermis to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete CategoriePermis from database by reference (reference)
    *
    * @param reference - reference of CategoriePermis to be deleted
    * @return 1 if CategoriePermis deleted successfully
    */
    int deleteByReference(String reference);





}
