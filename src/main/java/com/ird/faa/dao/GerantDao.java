package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Gerant;


@Repository
public interface GerantDao extends JpaRepository<Gerant,Long> {



@Query("SELECT item FROM Gerant item ")
List<Gerant> findAll();


    Gerant findByReference(String reference);

    int deleteByReference(String reference);

    List<Gerant> findByGenderReference(String reference);
    int deleteByGenderReference(String reference);

    List<Gerant> findByGenderId(Long id);

    int deleteByGenderId(Long id);


}
