package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PlanningItem;
import com.ird.faa.ws.rest.provided.vo.PlanningItemVo;

@Component
public class PlanningItemConverter extends AbstractConverter<PlanningItem,PlanningItemVo>{

        @Autowired
        private JourConverter jourConverter ;
    private Boolean jour;
    private Boolean ecole;

public  PlanningItemConverter(){
init(true);
}

@Override
public PlanningItem toItem(PlanningItemVo vo) {
if (vo == null) {
return null;
} else {
PlanningItem item = new PlanningItem();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getDateOuverture()))
        item.setDateOuverture(DateUtil.parse(vo.getDateOuverture()));
        if(StringUtil.isNotEmpty(vo.getDateFermeture()))
        item.setDateFermeture(DateUtil.parse(vo.getDateFermeture()));
    if(vo.getJourVo()!=null && this.jour)
        item.setJour(jourConverter.toItem(vo.getJourVo())) ;


return item;
}
}

@Override
public PlanningItemVo toVo(PlanningItem item) {
if (item == null) {
return null;
} else {
PlanningItemVo vo = new PlanningItemVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getDateOuverture()!=null)
        vo.setDateOuverture(DateUtil.formateDate(item.getDateOuverture()));
        if(item.getDateFermeture()!=null)
        vo.setDateFermeture(DateUtil.formateDate(item.getDateFermeture()));
    if(item.getJour()!=null && this.jour) {
        vo.setJourVo(jourConverter.toVo(item.getJour())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    jour = value;
}


        public JourConverter getJourConverter(){
        return this.jourConverter;
        }
        public void setJourConverter(JourConverter jourConverter ){
        this.jourConverter = jourConverter;
        }

    public boolean  isJour(){
    return this.jour;
    }
    public void  setJour(boolean jour){
    this.jour = jour;
    }

    public boolean isEcole() {
        return this.ecole;
    }

    public void setEcole(boolean ecole) {
        this.ecole = ecole;
    }







}
