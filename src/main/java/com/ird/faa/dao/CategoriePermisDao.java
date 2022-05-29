package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.CategoriePermis;


@Repository
public interface CategoriePermisDao extends JpaRepository<CategoriePermis,Long> {



@Query("SELECT item FROM CategoriePermis item ")
List<CategoriePermis> findAll();


    CategoriePermis findByReference(String reference);

    int deleteByReference(String reference);



}
