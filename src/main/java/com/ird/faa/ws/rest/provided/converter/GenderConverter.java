package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Gender;
import com.ird.faa.ws.rest.provided.vo.GenderVo;

@Component
public class GenderConverter extends AbstractConverter<Gender,GenderVo>{


public  GenderConverter(){
init(true);
}

@Override
public Gender toItem(GenderVo vo) {
if (vo == null) {
return null;
} else {
Gender item = new Gender();
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
public GenderVo toVo(Gender item) {
if (item == null) {
return null;
} else {
GenderVo vo = new GenderVo();
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
