package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Message;
import com.ird.faa.ws.rest.provided.vo.MessageVo;

@Component
public class MessageConverter extends AbstractConverter<Message,MessageVo>{

        @Autowired
        private EtatMessageConverter etatMessageConverter ;
    private Boolean etatMessage;

public  MessageConverter(){
init(true);
}

@Override
public Message toItem(MessageVo vo) {
if (vo == null) {
return null;
} else {
Message item = new Message();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getEmail()))
        item.setEmail(vo.getEmail());
        if(StringUtil.isNotEmpty(vo.getCorps()))
        item.setCorps(vo.getCorps());
        if(StringUtil.isNotEmpty(vo.getDateEnvoi()))
        item.setDateEnvoi(DateUtil.parse(vo.getDateEnvoi()));
    if(vo.getEtatMessageVo()!=null && this.etatMessage)
        item.setEtatMessage(etatMessageConverter.toItem(vo.getEtatMessageVo())) ;


return item;
}
}

@Override
public MessageVo toVo(Message item) {
if (item == null) {
return null;
} else {
MessageVo vo = new MessageVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getEmail()))
        vo.setEmail(item.getEmail());

        if(StringUtil.isNotEmpty(item.getCorps()))
        vo.setCorps(item.getCorps());

        if(item.getDateEnvoi()!=null)
        vo.setDateEnvoi(DateUtil.formateDate(item.getDateEnvoi()));
    if(item.getEtatMessage()!=null && this.etatMessage) {
        vo.setEtatMessageVo(etatMessageConverter.toVo(item.getEtatMessage())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    etatMessage = value;
}


        public EtatMessageConverter getEtatMessageConverter(){
        return this.etatMessageConverter;
        }
        public void setEtatMessageConverter(EtatMessageConverter etatMessageConverter ){
        this.etatMessageConverter = etatMessageConverter;
        }

    public boolean  isEtatMessage(){
    return this.etatMessage;
    }
    public void  setEtatMessage(boolean etatMessage){
    this.etatMessage = etatMessage;
    }












}
