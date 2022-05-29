package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Jour;


@Repository
public interface JourDao extends JpaRepository<Jour,Long> {



@Query("SELECT item FROM Jour item ")
List<Jour> findAll();


    Jour findByReference(String reference);

    int deleteByReference(String reference);



}
