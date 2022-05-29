package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypeVehicule;


@Repository
public interface TypeVehiculeDao extends JpaRepository<TypeVehicule,Long> {



@Query("SELECT item FROM TypeVehicule item ")
List<TypeVehicule> findAll();


    TypeVehicule findByReference(String reference);

    int deleteByReference(String reference);



}
