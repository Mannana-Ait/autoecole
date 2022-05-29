package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Vehicule;
import com.ird.faa.ws.rest.provided.vo.VehiculeVo;

@Component
public class VehiculeConverter extends AbstractConverter<Vehicule,VehiculeVo>{

        @Autowired
        private EcoleConverter ecoleConverter ;
        @Autowired
        private MarqueConverter marqueConverter ;
        @Autowired
        private TypeVehiculeConverter typeVehiculeConverter ;
    private Boolean marque;
    private Boolean typeVehicule;
    private Boolean ecole;

public  VehiculeConverter(){
init(true);
}

@Override
public Vehicule toItem(VehiculeVo vo) {
if (vo == null) {
return null;
} else {
Vehicule item = new Vehicule();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getMatricule()))
        item.setMatricule(vo.getMatricule());
        if(StringUtil.isNotEmpty(vo.getDateAchatVehicule()))
        item.setDateAchatVehicule(DateUtil.parse(vo.getDateAchatVehicule()));
        if(StringUtil.isNotEmpty(vo.getImageUrl()))
        item.setImageUrl(vo.getImageUrl());
    if(vo.getMarqueVo()!=null && this.marque)
        item.setMarque(marqueConverter.toItem(vo.getMarqueVo())) ;
    if(vo.getTypeVehiculeVo()!=null && this.typeVehicule)
        item.setTypeVehicule(typeVehiculeConverter.toItem(vo.getTypeVehiculeVo())) ;
    if(vo.getEcoleVo()!=null && this.ecole)
        item.setEcole(ecoleConverter.toItem(vo.getEcoleVo())) ;


return item;
}
}

@Override
public VehiculeVo toVo(Vehicule item) {
if (item == null) {
return null;
} else {
VehiculeVo vo = new VehiculeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getMatricule()))
        vo.setMatricule(item.getMatricule());

        if(item.getDateAchatVehicule()!=null)
        vo.setDateAchatVehicule(DateUtil.formateDate(item.getDateAchatVehicule()));
        if(StringUtil.isNotEmpty(item.getImageUrl()))
        vo.setImageUrl(item.getImageUrl());

    if(item.getMarque()!=null && this.marque) {
        vo.setMarqueVo(marqueConverter.toVo(item.getMarque())) ;
    }
    if(item.getTypeVehicule()!=null && this.typeVehicule) {
        vo.setTypeVehiculeVo(typeVehiculeConverter.toVo(item.getTypeVehicule())) ;
    }
    if(item.getEcole()!=null && this.ecole) {
        vo.setEcoleVo(ecoleConverter.toVo(item.getEcole())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    marque = value;
    typeVehicule = value;
    ecole = value;
}


        public EcoleConverter getEcoleConverter(){
        return this.ecoleConverter;
        }
        public void setEcoleConverter(EcoleConverter ecoleConverter ){
        this.ecoleConverter = ecoleConverter;
        }
        public MarqueConverter getMarqueConverter(){
        return this.marqueConverter;
        }
        public void setMarqueConverter(MarqueConverter marqueConverter ){
        this.marqueConverter = marqueConverter;
        }
        public TypeVehiculeConverter getTypeVehiculeConverter(){
        return this.typeVehiculeConverter;
        }
        public void setTypeVehiculeConverter(TypeVehiculeConverter typeVehiculeConverter ){
        this.typeVehiculeConverter = typeVehiculeConverter;
        }

    public boolean  isMarque(){
    return this.marque;
    }
    public void  setMarque(boolean marque){
    this.marque = marque;
    }
    public boolean  isTypeVehicule(){
    return this.typeVehicule;
    }
    public void  setTypeVehicule(boolean typeVehicule){
    this.typeVehicule = typeVehicule;
    }
    public boolean  isEcole(){
    return this.ecole;
    }
    public void  setEcole(boolean ecole){
    this.ecole = ecole;
    }














}
