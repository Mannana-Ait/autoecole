package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Ecole;
import com.ird.faa.ws.rest.provided.vo.EcoleVo;

@Component
public class EcoleConverter extends AbstractConverter<Ecole,EcoleVo>{

        @Autowired
        private VehiculeConverter vehiculeConverter ;
        @Autowired
        private PlanningItemConverter planningItemConverter ;
        @Autowired
        private MoniteurPratiqueConverter moniteurPratiqueConverter ;
        @Autowired
        private MoniteurTheoriqueConverter moniteurTheoriqueConverter ;
        @Autowired
        private VilleConverter villeConverter ;
        @Autowired
        private GerantConverter gerantConverter ;
    private Boolean ville;
    private Boolean gerant;
        private Boolean vehicules;
        private Boolean moniteurTheoriques;
        private Boolean moniteurPratiques;
        private Boolean planningItems;

public  EcoleConverter(){
init(true);
}

@Override
public Ecole toItem(EcoleVo vo) {
if (vo == null) {
return null;
} else {
Ecole item = new Ecole();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getAltitude()))
        item.setAltitude(NumberUtil.toBigDecimal(vo.getAltitude()));
        if(StringUtil.isNotEmpty(vo.getAngitude()))
        item.setAngitude(NumberUtil.toBigDecimal(vo.getAngitude()));
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getAddress()))
        item.setAddress(vo.getAddress());
        if(StringUtil.isNotEmpty(vo.getNumAutorisation()))
        item.setNumAutorisation(vo.getNumAutorisation());
        if(StringUtil.isNotEmpty(vo.getNumFix()))
        item.setNumFix(vo.getNumFix());
        if(StringUtil.isNotEmpty(vo.getNumPhone()))
        item.setNumPhone(vo.getNumPhone());
        if(StringUtil.isNotEmpty(vo.getEmail()))
        item.setEmail(vo.getEmail());
        if(StringUtil.isNotEmpty(vo.getTauxReussite()))
        item.setTauxReussite(NumberUtil.toBigDecimal(vo.getTauxReussite()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
        if(StringUtil.isNotEmpty(vo.getDateAbonnement()))
        item.setDateAbonnement(DateUtil.parse(vo.getDateAbonnement()));
    if(vo.getVilleVo()!=null && this.ville)
        item.setVille(villeConverter.toItem(vo.getVilleVo())) ;
    if(vo.getGerantVo()!=null && this.gerant)
        item.setGerant(gerantConverter.toItem(vo.getGerantVo())) ;

        if(ListUtil.isNotEmpty(vo.getVehiculesVo()) && this.vehicules)
            item.setVehicules(vehiculeConverter.toItem(vo.getVehiculesVo()));
        if(ListUtil.isNotEmpty(vo.getMoniteurTheoriquesVo()) && this.moniteurTheoriques)
            item.setMoniteurTheoriques(moniteurTheoriqueConverter.toItem(vo.getMoniteurTheoriquesVo()));
        if(ListUtil.isNotEmpty(vo.getMoniteurPratiquesVo()) && this.moniteurPratiques)
            item.setMoniteurPratiques(moniteurPratiqueConverter.toItem(vo.getMoniteurPratiquesVo()));
        if(ListUtil.isNotEmpty(vo.getPlanningItemsVo()) && this.planningItems)
            item.setPlanningItems(planningItemConverter.toItem(vo.getPlanningItemsVo()));

return item;
}
}

@Override
public EcoleVo toVo(Ecole item) {
if (item == null) {
return null;
} else {
EcoleVo vo = new EcoleVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getAltitude()!=null)
        vo.setAltitude(NumberUtil.toString(item.getAltitude()));

        if(item.getAngitude()!=null)
        vo.setAngitude(NumberUtil.toString(item.getAngitude()));

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getAddress()))
        vo.setAddress(item.getAddress());

        if(StringUtil.isNotEmpty(item.getNumAutorisation()))
        vo.setNumAutorisation(item.getNumAutorisation());

        if(StringUtil.isNotEmpty(item.getNumFix()))
        vo.setNumFix(item.getNumFix());

        if(StringUtil.isNotEmpty(item.getNumPhone()))
        vo.setNumPhone(item.getNumPhone());

        if(StringUtil.isNotEmpty(item.getEmail()))
        vo.setEmail(item.getEmail());

        if(item.getTauxReussite()!=null)
        vo.setTauxReussite(NumberUtil.toString(item.getTauxReussite()));

        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
        if(item.getDateAbonnement()!=null)
        vo.setDateAbonnement(DateUtil.formateDate(item.getDateAbonnement()));
    if(item.getVille()!=null && this.ville) {
        vo.setVilleVo(villeConverter.toVo(item.getVille())) ;
    }
    if(item.getGerant()!=null && this.gerant) {
        vo.setGerantVo(gerantConverter.toVo(item.getGerant())) ;
    }
        if(this.vehicules && ListUtil.isNotEmpty(item.getVehicules())){
        vehiculeConverter.init(true);
        vehiculeConverter.setEcole(false);
        vo.setVehiculesVo(vehiculeConverter.toVo(item.getVehicules()));
        vehiculeConverter.setEcole(true);
        }
        if(this.moniteurTheoriques && ListUtil.isNotEmpty(item.getMoniteurTheoriques())){
        moniteurTheoriqueConverter.init(true);
        moniteurTheoriqueConverter.setEcole(false);
        vo.setMoniteurTheoriquesVo(moniteurTheoriqueConverter.toVo(item.getMoniteurTheoriques()));
        moniteurTheoriqueConverter.setEcole(true);
        }
        if(this.moniteurPratiques && ListUtil.isNotEmpty(item.getMoniteurPratiques())){
        moniteurPratiqueConverter.init(true);
        moniteurPratiqueConverter.setEcole(false);
        vo.setMoniteurPratiquesVo(moniteurPratiqueConverter.toVo(item.getMoniteurPratiques()));
        moniteurPratiqueConverter.setEcole(true);
        }
        if(this.planningItems && ListUtil.isNotEmpty(item.getPlanningItems())){
        planningItemConverter.init(true);
        planningItemConverter.setEcole(false);
        vo.setPlanningItemsVo(planningItemConverter.toVo(item.getPlanningItems()));
        planningItemConverter.setEcole(true);
        }

return vo;
}
}

    public void initList(Boolean value) {
            this.vehicules = value;
            this.moniteurTheoriques = value;
            this.moniteurPratiques = value;
            this.planningItems = value;
    }
public void init(Boolean value) {
    ville = value;
    gerant = value;
    initList(value);
}


        public VehiculeConverter getVehiculeConverter(){
        return this.vehiculeConverter;
        }
        public void setVehiculeConverter(VehiculeConverter vehiculeConverter ){
        this.vehiculeConverter = vehiculeConverter;
        }
        public PlanningItemConverter getPlanningItemConverter(){
        return this.planningItemConverter;
        }
        public void setPlanningItemConverter(PlanningItemConverter planningItemConverter ){
        this.planningItemConverter = planningItemConverter;
        }
        public MoniteurPratiqueConverter getMoniteurPratiqueConverter(){
        return this.moniteurPratiqueConverter;
        }
        public void setMoniteurPratiqueConverter(MoniteurPratiqueConverter moniteurPratiqueConverter ){
        this.moniteurPratiqueConverter = moniteurPratiqueConverter;
        }
        public MoniteurTheoriqueConverter getMoniteurTheoriqueConverter(){
        return this.moniteurTheoriqueConverter;
        }
        public void setMoniteurTheoriqueConverter(MoniteurTheoriqueConverter moniteurTheoriqueConverter ){
        this.moniteurTheoriqueConverter = moniteurTheoriqueConverter;
        }
        public VilleConverter getVilleConverter(){
        return this.villeConverter;
        }
        public void setVilleConverter(VilleConverter villeConverter ){
        this.villeConverter = villeConverter;
        }
        public GerantConverter getGerantConverter(){
        return this.gerantConverter;
        }
        public void setGerantConverter(GerantConverter gerantConverter ){
        this.gerantConverter = gerantConverter;
        }

    public boolean  isVille(){
    return this.ville;
    }
    public void  setVille(boolean ville){
    this.ville = ville;
    }
    public boolean  isGerant(){
    return this.gerant;
    }
    public void  setGerant(boolean gerant){
    this.gerant = gerant;
    }































        public Boolean  isVehicules(){
        return this.vehicules ;
        }
        public void  setVehicules(Boolean vehicules ){
        this.vehicules  = vehicules ;
        }



        public Boolean  isMoniteurTheoriques(){
        return this.moniteurTheoriques ;
        }
        public void  setMoniteurTheoriques(Boolean moniteurTheoriques ){
        this.moniteurTheoriques  = moniteurTheoriques ;
        }



        public Boolean  isMoniteurPratiques(){
        return this.moniteurPratiques ;
        }
        public void  setMoniteurPratiques(Boolean moniteurPratiques ){
        this.moniteurPratiques  = moniteurPratiques ;
        }



        public Boolean  isPlanningItems(){
        return this.planningItems ;
        }
        public void  setPlanningItems(Boolean planningItems ){
        this.planningItems  = planningItems ;
        }


}
