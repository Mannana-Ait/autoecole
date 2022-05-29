package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.AvisVisiteur;


@Repository
public interface AvisVisiteurDao extends JpaRepository<AvisVisiteur,Long> {



@Query("SELECT item FROM AvisVisiteur item ")
List<AvisVisiteur> findAll();


    AvisVisiteur findByReference(String reference);

    int deleteByReference(String reference);

    List<AvisVisiteur> findByTypeAvisReference(String reference);
    int deleteByTypeAvisReference(String reference);

    List<AvisVisiteur> findByTypeAvisId(Long id);

    int deleteByTypeAvisId(Long id);


}
