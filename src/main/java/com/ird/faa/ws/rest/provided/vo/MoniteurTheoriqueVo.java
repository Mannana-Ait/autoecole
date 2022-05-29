package com.ird.faa.ws.rest.provided.vo;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MoniteurTheoriqueVo {

    private String id;
    private String reference;
    private String nom;
    private String prenom;
    private String email;
    private String adress;
    private String phone;
    private String fix;
    private String lieuNaissance;
    private String dateNaissance;
    private String cin;
    private String picture;


    private String lieuNaissanceMax;
    private String lieuNaissanceMin;
    private String dateNaissanceMax;
    private String dateNaissanceMin;

    private GenderVo genderVo;

    private EcoleVo ecoleVo;


    public MoniteurTheoriqueVo() {
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

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFix() {
        return this.fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public String getLieuNaissance() {
        return this.lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getLieuNaissanceMax() {
        return this.lieuNaissanceMax;
    }

    public String getLieuNaissanceMin() {
        return this.lieuNaissanceMin;
    }

    public void setLieuNaissanceMax(String lieuNaissanceMax) {
        this.lieuNaissanceMax = lieuNaissanceMax;
    }

    public void setLieuNaissanceMin(String lieuNaissanceMin) {
        this.lieuNaissanceMin = lieuNaissanceMin;
    }

    public String getDateNaissanceMax() {
        return this.dateNaissanceMax;
    }

    public String getDateNaissanceMin() {
        return this.dateNaissanceMin;
    }

    public void setDateNaissanceMax(String dateNaissanceMax) {
        this.dateNaissanceMax = dateNaissanceMax;
    }

    public void setDateNaissanceMin(String dateNaissanceMin) {
        this.dateNaissanceMin = dateNaissanceMin;
    }


    public GenderVo getGenderVo() {
        return this.genderVo;
    }

    public void setGenderVo(GenderVo genderVo) {
        this.genderVo = genderVo;
    }

    public EcoleVo getEcoleVo() {
        return ecoleVo;
    }

    public void setEcoleVo(EcoleVo ecoleVo) {
        this.ecoleVo = ecoleVo;
    }


}
