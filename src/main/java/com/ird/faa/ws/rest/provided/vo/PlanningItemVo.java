package com.ird.faa.ws.rest.provided.vo;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PlanningItemVo {

    private String id;
    private String dateOuverture;
    private String dateFermeture;


    private String dateOuvertureMax;
    private String dateOuvertureMin;
    private String dateFermetureMax;
    private String dateFermetureMin;

    private JourVo jourVo;

    private EcoleVo ecoleVo;


    public PlanningItemVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateOuverture() {
        return this.dateOuverture;
    }

    public void setDateOuverture(String dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public String getDateFermeture() {
        return this.dateFermeture;
    }

    public void setDateFermeture(String dateFermeture) {
        this.dateFermeture = dateFermeture;
    }


    public String getDateOuvertureMax() {
        return this.dateOuvertureMax;
    }

    public String getDateOuvertureMin() {
        return this.dateOuvertureMin;
    }

    public void setDateOuvertureMax(String dateOuvertureMax) {
        this.dateOuvertureMax = dateOuvertureMax;
    }

    public void setDateOuvertureMin(String dateOuvertureMin) {
        this.dateOuvertureMin = dateOuvertureMin;
    }

    public String getDateFermetureMax() {
        return this.dateFermetureMax;
    }

    public String getDateFermetureMin() {
        return this.dateFermetureMin;
    }

    public void setDateFermetureMax(String dateFermetureMax) {
        this.dateFermetureMax = dateFermetureMax;
    }

    public void setDateFermetureMin(String dateFermetureMin) {
        this.dateFermetureMin = dateFermetureMin;
    }


    public JourVo getJourVo() {
        return this.jourVo;
    }

    public void setJourVo(JourVo jourVo) {
        this.jourVo = jourVo;
    }

    public EcoleVo getEcoleVo() {
        return ecoleVo;
    }

    public void setEcoleVo(EcoleVo ecoleVo) {
        this.ecoleVo = ecoleVo;
    }


}
