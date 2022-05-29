package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Vehicule;


@Repository
public interface VehiculeDao extends JpaRepository<Vehicule,Long> {



@Query("SELECT item FROM Vehicule item ")
List<Vehicule> findAll();



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
