package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Gerant;
import com.ird.faa.ws.rest.provided.vo.GerantVo;

@Component
public class GerantConverter extends AbstractConverter<Gerant,GerantVo>{

        @Autowired
        private GenderConverter genderConverter ;
    private Boolean gender;

public  GerantConverter(){
init(true);
}

@Override
public Gerant toItem(GerantVo vo) {
if (vo == null) {
return null;
} else {
Gerant item = new Gerant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
        if(StringUtil.isNotEmpty(vo.getEmail()))
        item.setEmail(vo.getEmail());
        if(StringUtil.isNotEmpty(vo.getAdress()))
        item.setAdress(vo.getAdress());
        if(StringUtil.isNotEmpty(vo.getPhone()))
        item.setPhone(vo.getPhone());
        if(StringUtil.isNotEmpty(vo.getFix()))
        item.setFix(vo.getFix());
        if(StringUtil.isNotEmpty(vo.getLieuNaissance()))
        item.setLieuNaissance(vo.getLieuNaissance());
        if(StringUtil.isNotEmpty(vo.getDateNaissance()))
        item.setDateNaissance(vo.getDateNaissance());
        if(StringUtil.isNotEmpty(vo.getCin()))
        item.setCin(vo.getCin());
        if(StringUtil.isNotEmpty(vo.getPicture()))
        item.setPicture(vo.getPicture());
        if(StringUtil.isNotEmpty(vo.getDateJoin()))
        item.setDateJoin(DateUtil.parse(vo.getDateJoin()));
    if(vo.getGenderVo()!=null && this.gender)
        item.setGender(genderConverter.toItem(vo.getGenderVo())) ;


return item;
}
}

@Override
public GerantVo toVo(Gerant item) {
if (item == null) {
return null;
} else {
GerantVo vo = new GerantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

        if(StringUtil.isNotEmpty(item.getEmail()))
        vo.setEmail(item.getEmail());

        if(StringUtil.isNotEmpty(item.getAdress()))
        vo.setAdress(item.getAdress());

        if(StringUtil.isNotEmpty(item.getPhone()))
        vo.setPhone(item.getPhone());

        if(StringUtil.isNotEmpty(item.getFix()))
        vo.setFix(item.getFix());

        if(StringUtil.isNotEmpty(item.getLieuNaissance()))
        vo.setLieuNaissance(item.getLieuNaissance());

        if(StringUtil.isNotEmpty(item.getDateNaissance()))
        vo.setDateNaissance(item.getDateNaissance());

        if(StringUtil.isNotEmpty(item.getCin()))
        vo.setCin(item.getCin());

        if(StringUtil.isNotEmpty(item.getPicture()))
        vo.setPicture(item.getPicture());

        if(item.getDateJoin()!=null)
        vo.setDateJoin(DateUtil.formateDate(item.getDateJoin()));
    if(item.getGender()!=null && this.gender) {
        vo.setGenderVo(genderConverter.toVo(item.getGender())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    gender = value;
}


        public GenderConverter getGenderConverter(){
        return this.genderConverter;
        }
        public void setGenderConverter(GenderConverter genderConverter ){
        this.genderConverter = genderConverter;
        }

    public boolean  isGender(){
    return this.gender;
    }
    public void  setGender(boolean gender){
    this.gender = gender;
    }




























}
