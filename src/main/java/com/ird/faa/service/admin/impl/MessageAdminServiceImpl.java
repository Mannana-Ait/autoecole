package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Message;
        import com.ird.faa.bean.EtatMessage;
import com.ird.faa.dao.MessageDao;
import com.ird.faa.service.admin.facade.MessageAdminService;
        import com.ird.faa.service.admin.facade.EtatMessageAdminService;

import com.ird.faa.ws.rest.provided.vo.MessageVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class MessageAdminServiceImpl extends AbstractServiceImpl<Message> implements MessageAdminService {

@Autowired
private MessageDao messageDao;

        @Autowired
        private EtatMessageAdminService etatMessageService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Message> findAll(){
        return messageDao.findAll();
}

        @Override
        public List<Message> findByEtatMessageReference(String reference){
        return messageDao.findByEtatMessageReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEtatMessageReference(String reference){
        return messageDao.deleteByEtatMessageReference(reference);
        }

        @Override
        public List<Message> findByEtatMessageId(Long id){
        return messageDao.findByEtatMessageId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatMessageId(Long id){
        return messageDao.deleteByEtatMessageId(id);
        }

    @Override
    public Message findByReference(String reference){
    if( reference==null) return null;
    return messageDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return messageDao.deleteByReference(reference);
    }
    @Override
    public Message findByIdOrReference(Message message){
    Message resultat=null;
    if(message != null){
    if(StringUtil.isNotEmpty(message.getId())){
    resultat= messageDao.getOne(message.getId());
    }else if(StringUtil.isNotEmpty(message.getReference())) {
    resultat= messageDao.findByReference(message.getReference());
    }
    }
    return resultat;
    }

@Override
public Message findById(Long id){
if(id==null) return null;
return messageDao.getOne(id);
}

@Override
public Message findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(messageDao.findById(id).isPresent())  {
messageDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Message update(Message message){
Message foundedMessage = findById(message.getId());
if(foundedMessage==null) return null;
else{
return  messageDao.save(message);
}
}

@Override
public Message save (Message message){

    Message result =null;
    Message foundedMessage = findByReference(message.getReference());
    if(foundedMessage == null){



    findEtatMessage(message);

    Message savedMessage = messageDao.save(message);

    result = savedMessage;
    }

    return result;
}

@Override
public List<Message> save(List<Message> messages){
List<Message> list = new ArrayList<>();
for(Message message: messages){
list.add(save(message));
}
return list;
}



@Override
@Transactional
public int delete(Message message){
    if(message.getReference()==null) return -1;

    Message foundedMessage = findByReference(message.getReference());
    if(foundedMessage==null) return -1;
messageDao.delete(foundedMessage);
return 1;
}


public List<Message> findByCriteria(MessageVo messageVo){

String query = "SELECT o FROM Message o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",messageVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",messageVo.getReference());
            query += SearchUtil.addConstraint( "o", "email","LIKE",messageVo.getEmail());
            query += SearchUtil.addConstraint( "o", "corps","LIKE",messageVo.getCorps());
        query += SearchUtil.addConstraintDate( "o", "dateEnvoi","=",messageVo.getDateEnvoi());
            query += SearchUtil.addConstraintMinMaxDate("o","dateEnvoi",messageVo.getDateEnvoiMin(),messageVo.getDateEnvoiMax());
    if(messageVo.getEtatMessageVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatMessage.id","=",messageVo.getEtatMessageVo().getId());
            query += SearchUtil.addConstraint( "o", "etatMessage.reference","LIKE",messageVo.getEtatMessageVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findEtatMessage(Message message){
        EtatMessage loadedEtatMessage =etatMessageService.findByIdOrReference(message.getEtatMessage());

    if(loadedEtatMessage==null ) {
    return;
    }
    message.setEtatMessage(loadedEtatMessage);
    }

@Override
@Transactional
public void delete(List<Message> messages){
if(ListUtil.isNotEmpty(messages)){
messages.forEach(e->messageDao.delete(e));
}
}
@Override
public void update(List<Message> messages){
if(ListUtil.isNotEmpty(messages)){
messages.forEach(e->messageDao.save(e));
}
}





    }
