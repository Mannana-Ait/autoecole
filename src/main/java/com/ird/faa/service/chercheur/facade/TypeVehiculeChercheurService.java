package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.TypeVehicule;
import com.ird.faa.ws.rest.provided.vo.TypeVehiculeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeVehiculeChercheurService extends AbstractService<TypeVehicule,Long,TypeVehiculeVo>{



    /**
    * find TypeVehicule from database by reference (reference)
    * @param reference - reference of TypeVehicule
    * @return the founded TypeVehicule , If no TypeVehicule were
    *         found in database return  null.
    */
    TypeVehicule findByReference(String reference);

    /**
    * find TypeVehicule from database by id (PK) or reference (reference)
    * @param id - id of TypeVehicule
    * @param reference - reference of TypeVehicule
    * @return the founded TypeVehicule , If no TypeVehicule were
    *         found in database return  null.
    */
    TypeVehicule findByIdOrReference(TypeVehicule typeVehicule);


/**
    * delete TypeVehicule from database
    * @param id - id of TypeVehicule to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TypeVehicule from database by reference (reference)
    *
    * @param reference - reference of TypeVehicule to be deleted
    * @return 1 if TypeVehicule deleted successfully
    */
    int deleteByReference(String reference);





}
