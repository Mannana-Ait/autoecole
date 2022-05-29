package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.MoniteurTheorique;
import com.ird.faa.ws.rest.provided.vo.MoniteurTheoriqueVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface MoniteurTheoriqueChercheurService extends AbstractService<MoniteurTheorique,Long,MoniteurTheoriqueVo>{



    /**
    * find MoniteurTheorique from database by reference (reference)
    * @param reference - reference of MoniteurTheorique
    * @return the founded MoniteurTheorique , If no MoniteurTheorique were
    *         found in database return  null.
    */
    MoniteurTheorique findByReference(String reference);

    /**
    * find MoniteurTheorique from database by id (PK) or reference (reference)
    * @param id - id of MoniteurTheorique
    * @param reference - reference of MoniteurTheorique
    * @return the founded MoniteurTheorique , If no MoniteurTheorique were
    *         found in database return  null.
    */
    MoniteurTheorique findByIdOrReference(MoniteurTheorique moniteurTheorique);


/**
    * delete MoniteurTheorique from database
    * @param id - id of MoniteurTheorique to be deleted
    *
    */
    int deleteById(Long id);


    List<MoniteurTheorique> findByGenderReference(String reference);



    int deleteByGenderReference(String reference);

    List<MoniteurTheorique> findByGenderId(Long id);

    int deleteByGenderId(Long id);
    int deleteByEcoleId(Long id);
    List<MoniteurTheorique> findByEcoleId(Long id);


    /**
    * delete MoniteurTheorique from database by reference (reference)
    *
    * @param reference - reference of MoniteurTheorique to be deleted
    * @return 1 if MoniteurTheorique deleted successfully
    */
    int deleteByReference(String reference);





}
