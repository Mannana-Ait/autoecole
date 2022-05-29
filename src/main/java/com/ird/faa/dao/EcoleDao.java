package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.ird.faa.bean.Ecole;


@Repository
public interface EcoleDao extends JpaRepository<Ecole, Long> {


    @Query("SELECT item FROM Ecole item ")
    List<Ecole> findAll();


    Ecole findByReference(String reference);

    int deleteByReference(String reference);

    List<Ecole> findByVilleReference(String reference);

    int deleteByVilleReference(String reference);

    List<Ecole> findByVilleId(Long id);

    int deleteByVilleId(Long id);

    List<Ecole> findByGerantReference(String reference);

    int deleteByGerantReference(String reference);

    List<Ecole> findByGerantId(Long id);

    int deleteByGerantId(Long id);


}
