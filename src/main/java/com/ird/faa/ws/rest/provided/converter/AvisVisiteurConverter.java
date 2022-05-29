package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.AvisVisiteur;
import com.ird.faa.ws.rest.provided.vo.AvisVisiteurVo;

@Component
public class AvisVisiteurConverter extends AbstractConverter<AvisVisiteur,AvisVisiteurVo>{

        @Autowired
        private TypeAvisConverter typeAvisConverter ;
    private Boolean typeAvis;

public  AvisVisiteurConverter(){
init(true);
}

@Override
public AvisVisiteur toItem(AvisVisiteurVo vo) {
if (vo == null) {
return null;
} else {
AvisVisiteur item = new AvisVisiteur();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getEmailVisiteur()))
        item.setEmailVisiteur(vo.getEmailVisiteur());
        if(StringUtil.isNotEmpty(vo.getObjet()))
        item.setObjet(vo.getObjet());
        if(StringUtil.isNotEmpty(vo.getMessage()))
        item.setMessage(vo.getMessage());
        if(StringUtil.isNotEmpty(vo.getRatting()))
        item.setRatting(NumberUtil.toBigDecimal(vo.getRatting()));
    if(vo.getTypeAvisVo()!=null && this.typeAvis)
        item.setTypeAvis(typeAvisConverter.toItem(vo.getTypeAvisVo())) ;


return item;
}
}

@Override
public AvisVisiteurVo toVo(AvisVisiteur item) {
if (item == null) {
return null;
} else {
AvisVisiteurVo vo = new AvisVisiteurVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getEmailVisiteur()))
        vo.setEmailVisiteur(item.getEmailVisiteur());

        if(StringUtil.isNotEmpty(item.getObjet()))
        vo.setObjet(item.getObjet());

        if(StringUtil.isNotEmpty(item.getMessage()))
        vo.setMessage(item.getMessage());

        if(item.getRatting()!=null)
        vo.setRatting(NumberUtil.toString(item.getRatting()));

    if(item.getTypeAvis()!=null && this.typeAvis) {
        vo.setTypeAvisVo(typeAvisConverter.toVo(item.getTypeAvis())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    typeAvis = value;
}


        public TypeAvisConverter getTypeAvisConverter(){
        return this.typeAvisConverter;
        }
        public void setTypeAvisConverter(TypeAvisConverter typeAvisConverter ){
        this.typeAvisConverter = typeAvisConverter;
        }

    public boolean  isTypeAvis(){
    return this.typeAvis;
    }
    public void  setTypeAvis(boolean typeAvis){
    this.typeAvis = typeAvis;
    }














}
