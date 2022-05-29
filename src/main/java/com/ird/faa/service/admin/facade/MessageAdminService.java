package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Message;
import com.ird.faa.ws.rest.provided.vo.MessageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface MessageAdminService extends AbstractService<Message,Long,MessageVo>{



    /**
    * find Message from database by reference (reference)
    * @param reference - reference of Message
    * @return the founded Message , If no Message were
    *         found in database return  null.
    */
    Message findByReference(String reference);

    /**
    * find Message from database by id (PK) or reference (reference)
    * @param id - id of Message
    * @param reference - reference of Message
    * @return the founded Message , If no Message were
    *         found in database return  null.
    */
    Message findByIdOrReference(Message message);


/**
    * delete Message from database
    * @param id - id of Message to be deleted
    *
    */
    int deleteById(Long id);


    List<Message> findByEtatMessageReference(String reference);

    int deleteByEtatMessageReference(String reference);

    List<Message> findByEtatMessageId(Long id);

    int deleteByEtatMessageId(Long id);


    /**
    * delete Message from database by reference (reference)
    *
    * @param reference - reference of Message to be deleted
    * @return 1 if Message deleted successfully
    */
    int deleteByReference(String reference);





}
