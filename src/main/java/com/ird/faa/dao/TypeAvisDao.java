package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypeAvis;


@Repository
public interface TypeAvisDao extends JpaRepository<TypeAvis,Long> {



@Query("SELECT item FROM TypeAvis item ")
List<TypeAvis> findAll();


    TypeAvis findByReference(String reference);

    int deleteByReference(String reference);



}
