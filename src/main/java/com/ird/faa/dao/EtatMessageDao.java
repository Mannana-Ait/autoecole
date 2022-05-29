package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.EtatMessage;


@Repository
public interface EtatMessageDao extends JpaRepository<EtatMessage,Long> {



@Query("SELECT item FROM EtatMessage item ")
List<EtatMessage> findAll();


    EtatMessage findByReference(String reference);

    int deleteByReference(String reference);



}
