package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Gender;


@Repository
public interface GenderDao extends JpaRepository<Gender,Long> {



@Query("SELECT item FROM Gender item ")
List<Gender> findAll();


    Gender findByReference(String reference);

    int deleteByReference(String reference);



}
