package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Marque;


@Repository
public interface MarqueDao extends JpaRepository<Marque,Long> {



@Query("SELECT item FROM Marque item ")
List<Marque> findAll();


    Marque findByReference(String reference);

    int deleteByReference(String reference);



}
