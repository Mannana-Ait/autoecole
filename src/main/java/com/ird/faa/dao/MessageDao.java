package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Message;


@Repository
public interface MessageDao extends JpaRepository<Message,Long> {



@Query("SELECT item FROM Message item ")
List<Message> findAll();


    Message findByReference(String reference);

    int deleteByReference(String reference);

    List<Message> findByEtatMessageReference(String reference);
    int deleteByEtatMessageReference(String reference);

    List<Message> findByEtatMessageId(Long id);

    int deleteByEtatMessageId(Long id);


}
