package com.ird.faa.dao;

import com.ird.faa.bean.MoniteurPratique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.MoniteurTheorique;


@Repository
public interface MoniteurTheoriqueDao extends JpaRepository<MoniteurTheorique,Long> {



@Query("SELECT item FROM MoniteurTheorique item ")
List<MoniteurTheorique> findAll();


    MoniteurTheorique findByReference(String reference);

    int deleteByReference(String reference);

    List<MoniteurTheorique> findByGenderReference(String reference);
    int deleteByGenderReference(String reference);

    List<MoniteurTheorique> findByGenderId(Long id);

    int deleteByGenderId(Long id);

    List<MoniteurTheorique> findByEcoleId(Long id);

    int deleteByEcoleId(Long id);


}
