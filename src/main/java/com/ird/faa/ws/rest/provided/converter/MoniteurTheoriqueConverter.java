package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.MoniteurTheorique;
import com.ird.faa.ws.rest.provided.vo.MoniteurTheoriqueVo;

@Component
public class MoniteurTheoriqueConverter extends AbstractConverter<MoniteurTheorique, MoniteurTheoriqueVo> {

    @Autowired
    private GenderConverter genderConverter;
    private Boolean gender;
    private Boolean ecole;

    public MoniteurTheoriqueConverter() {
        init(true);
    }

    @Override
    public MoniteurTheorique toItem(MoniteurTheoriqueVo vo) {
        if (vo == null) {
            return null;
        } else {
            MoniteurTheorique item = new MoniteurTheorique();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getNom()))
                item.setNom(vo.getNom());
            if (StringUtil.isNotEmpty(vo.getPrenom()))
                item.setPrenom(vo.getPrenom());
            if (StringUtil.isNotEmpty(vo.getEmail()))
                item.setEmail(vo.getEmail());
            if (StringUtil.isNotEmpty(vo.getAdress()))
                item.setAdress(vo.getAdress());
            if (StringUtil.isNotEmpty(vo.getPhone()))
                item.setPhone(vo.getPhone());
            if (StringUtil.isNotEmpty(vo.getFix()))
                item.setFix(vo.getFix());
            if (StringUtil.isNotEmpty(vo.getLieuNaissance()))
                item.setLieuNaissance(DateUtil.parse(vo.getLieuNaissance()));
            if (StringUtil.isNotEmpty(vo.getDateNaissance()))
                item.setDateNaissance(DateUtil.parse(vo.getDateNaissance()));
            if (StringUtil.isNotEmpty(vo.getCin()))
                item.setCin(vo.getCin());
            if (StringUtil.isNotEmpty(vo.getPicture()))
                item.setPicture(vo.getPicture());
            if (vo.getGenderVo() != null && this.gender)
                item.setGender(genderConverter.toItem(vo.getGenderVo()));


            return item;
        }
    }

    @Override
    public MoniteurTheoriqueVo toVo(MoniteurTheorique item) {
        if (item == null) {
            return null;
        } else {
            MoniteurTheoriqueVo vo = new MoniteurTheoriqueVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (StringUtil.isNotEmpty(item.getNom()))
                vo.setNom(item.getNom());

            if (StringUtil.isNotEmpty(item.getPrenom()))
                vo.setPrenom(item.getPrenom());

            if (StringUtil.isNotEmpty(item.getEmail()))
                vo.setEmail(item.getEmail());

            if (StringUtil.isNotEmpty(item.getAdress()))
                vo.setAdress(item.getAdress());

            if (StringUtil.isNotEmpty(item.getPhone()))
                vo.setPhone(item.getPhone());

            if (StringUtil.isNotEmpty(item.getFix()))
                vo.setFix(item.getFix());

            if (item.getLieuNaissance() != null)
                vo.setLieuNaissance(DateUtil.formateDate(item.getLieuNaissance()));
            if (item.getDateNaissance() != null)
                vo.setDateNaissance(DateUtil.formateDate(item.getDateNaissance()));
            if (StringUtil.isNotEmpty(item.getCin()))
                vo.setCin(item.getCin());

            if (StringUtil.isNotEmpty(item.getPicture()))
                vo.setPicture(item.getPicture());

            if (item.getGender() != null && this.gender) {
                vo.setGenderVo(genderConverter.toVo(item.getGender()));
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        gender = value;
        ecole = value;
    }


    public GenderConverter getGenderConverter() {
        return this.genderConverter;
    }

    public void setGenderConverter(GenderConverter genderConverter) {
        this.genderConverter = genderConverter;
    }

    public boolean isGender() {
        return this.gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isEcole() {
        return this.ecole;
    }

    public void setEcole(boolean ecole) {
        this.ecole = ecole;
    }

}
