package com.ird.faa.ws.rest.provided.vo;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PermisVo {

    private String id;
    private String reference;
    private String dateDelivre;
    private String numberPermis;
    private String nomDelivreur;


    private String dateDelivreMax;
    private String dateDelivreMin;
    private String numberPermisMax;
    private String numberPermisMin;

    private CategoriePermisVo categoriePermisVo;


    public PermisVo() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDateDelivre() {
        return this.dateDelivre;
    }

    public void setDateDelivre(String dateDelivre) {
        this.dateDelivre = dateDelivre;
    }

    public String getNumberPermis() {
        return this.numberPermis;
    }

    public void setNumberPermis(String numberPermis) {
        this.numberPermis = numberPermis;
    }

    public String getNomDelivreur() {
        return this.nomDelivreur;
    }

    public void setNomDelivreur(String nomDelivreur) {
        this.nomDelivreur = nomDelivreur;
    }


    public String getDateDelivreMax() {
        return this.dateDelivreMax;
    }

    public String getDateDelivreMin() {
        return this.dateDelivreMin;
    }

    public void setDateDelivreMax(String dateDelivreMax) {
        this.dateDelivreMax = dateDelivreMax;
    }

    public void setDateDelivreMin(String dateDelivreMin) {
        this.dateDelivreMin = dateDelivreMin;
    }

    public String getNumberPermisMax() {
        return this.numberPermisMax;
    }

    public String getNumberPermisMin() {
        return this.numberPermisMin;
    }

    public void setNumberPermisMax(String numberPermisMax) {
        this.numberPermisMax = numberPermisMax;
    }

    public void setNumberPermisMin(String numberPermisMin) {
        this.numberPermisMin = numberPermisMin;
    }


    public CategoriePermisVo getCategoriePermisVo() {
        return this.categoriePermisVo;
    }

    public void setCategoriePermisVo(CategoriePermisVo categoriePermisVo) {
        this.categoriePermisVo = categoriePermisVo;
    }


}
