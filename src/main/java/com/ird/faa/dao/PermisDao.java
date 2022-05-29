package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Permis;


@Repository
public interface PermisDao extends JpaRepository<Permis,Long> {



@Query("SELECT item FROM Permis item ")
List<Permis> findAll();


    Permis findByReference(String reference);

    int deleteByReference(String reference);

    List<Permis> findByCategoriePermisReference(String reference);
    int deleteByCategoriePermisReference(String reference);

    List<Permis> findByCategoriePermisId(Long id);

    int deleteByCategoriePermisId(Long id);


}
