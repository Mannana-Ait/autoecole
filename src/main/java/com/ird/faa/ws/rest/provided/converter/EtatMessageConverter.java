package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatMessage;
import com.ird.faa.ws.rest.provided.vo.EtatMessageVo;

@Component
public class EtatMessageConverter extends AbstractConverter<EtatMessage,EtatMessageVo>{


public  EtatMessageConverter(){
init(true);
}

@Override
public EtatMessage toItem(EtatMessageVo vo) {
if (vo == null) {
return null;
} else {
EtatMessage item = new EtatMessage();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());


return item;
}
}

@Override
public EtatMessageVo toVo(EtatMessage item) {
if (item == null) {
return null;
} else {
EtatMessageVo vo = new EtatMessageVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());


return vo;
}
}

public void init(Boolean value) {
}









}
