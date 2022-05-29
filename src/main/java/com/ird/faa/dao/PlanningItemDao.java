package com.ird.faa.dao;

import com.ird.faa.bean.MoniteurTheorique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PlanningItem;


@Repository
public interface PlanningItemDao extends JpaRepository<PlanningItem,Long> {



@Query("SELECT item FROM PlanningItem item ")
List<PlanningItem> findAll();



    List<PlanningItem> findByJourReference(String reference);
    int deleteByJourReference(String reference);

    List<PlanningItem> findByJourId(Long id);

    int deleteByJourId(Long id);

    List<PlanningItem> findByEcoleId(Long id);

    int deleteByEcoleId(Long id);


}
