package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.MoniteurPratique;


@Repository
public interface MoniteurPratiqueDao extends JpaRepository<MoniteurPratique,Long> {



@Query("SELECT item FROM MoniteurPratique item ")
List<MoniteurPratique> findAll();


    MoniteurPratique findByReference(String reference);

    int deleteByReference(String reference);

    List<MoniteurPratique> findByGenderReference(String reference);
    int deleteByGenderReference(String reference);

    List<MoniteurPratique> findByGenderId(Long id);

    int deleteByGenderId(Long id);

    List<MoniteurPratique> findByEcoleId(Long id);

    int deleteByEcoleId(Long id);


}
