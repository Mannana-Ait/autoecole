package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Ville;


@Repository
public interface VilleDao extends JpaRepository<Ville,Long> {



@Query("SELECT item FROM Ville item ")
List<Ville> findAll();


    Ville findByReference(String reference);

    int deleteByReference(String reference);



}
