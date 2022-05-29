package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Vehicule;
import com.ird.faa.ws.rest.provided.vo.VehiculeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface VehiculeChercheurService extends AbstractService<Vehicule,Long,VehiculeVo>{





/**
    * delete Vehicule from database
    * @param id - id of Vehicule to be deleted
    *
    */
    int deleteById(Long id);


    List<Vehicule> findByMarqueReference(String reference);

    int deleteByMarqueReference(String reference);

    List<Vehicule> findByMarqueId(Long id);

    int deleteByMarqueId(Long id);
    List<Vehicule> findByTypeVehiculeReference(String reference);

    int deleteByTypeVehiculeReference(String reference);

    List<Vehicule> findByTypeVehiculeId(Long id);

    int deleteByTypeVehiculeId(Long id);
    List<Vehicule> findByEcoleReference(String reference);

    int deleteByEcoleReference(String reference);

    List<Vehicule> findByEcoleId(Long id);

    int deleteByEcoleId(Long id);







}
