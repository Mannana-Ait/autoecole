package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypeVehicule;
import com.ird.faa.ws.rest.provided.vo.TypeVehiculeVo;

@Component
public class TypeVehiculeConverter extends AbstractConverter<TypeVehicule,TypeVehiculeVo>{


public  TypeVehiculeConverter(){
init(true);
}

@Override
public TypeVehicule toItem(TypeVehiculeVo vo) {
if (vo == null) {
return null;
} else {
TypeVehicule item = new TypeVehicule();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibele()))
        item.setLibele(vo.getLibele());


return item;
}
}

@Override
public TypeVehiculeVo toVo(TypeVehicule item) {
if (item == null) {
return null;
} else {
TypeVehiculeVo vo = new TypeVehiculeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibele()))
        vo.setLibele(item.getLibele());


return vo;
}
}

public void init(Boolean value) {
}









}
