package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.CategoriePermis;
import com.ird.faa.ws.rest.provided.vo.CategoriePermisVo;

@Component
public class CategoriePermisConverter extends AbstractConverter<CategoriePermis,CategoriePermisVo>{


public  CategoriePermisConverter(){
init(true);
}

@Override
public CategoriePermis toItem(CategoriePermisVo vo) {
if (vo == null) {
return null;
} else {
CategoriePermis item = new CategoriePermis();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibele()))
        item.setLibele(vo.getLibele());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());


return item;
}
}

@Override
public CategoriePermisVo toVo(CategoriePermis item) {
if (item == null) {
return null;
} else {
CategoriePermisVo vo = new CategoriePermisVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibele()))
        vo.setLibele(item.getLibele());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());


return vo;
}
}

public void init(Boolean value) {
}











}
