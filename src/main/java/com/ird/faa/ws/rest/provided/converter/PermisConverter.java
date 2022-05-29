package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Permis;
import com.ird.faa.ws.rest.provided.vo.PermisVo;

@Component
public class PermisConverter extends AbstractConverter<Permis, PermisVo> {

    @Autowired
    private CategoriePermisConverter categoriePermisConverter;
    private Boolean categoriePermis;

    public PermisConverter() {
        init(true);
    }

    @Override
    public Permis toItem(PermisVo vo) {
        if (vo == null) {
            return null;
        } else {
            Permis item = new Permis();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getDateDelivre()))
                item.setDateDelivre(DateUtil.parse(vo.getDateDelivre()));
            if (vo.getNumberPermis() != null) item.setNumberPermis(NumberUtil.toInt(vo.getNumberPermis()));
            if (StringUtil.isNotEmpty(vo.getNomDelivreur()))
                item.setNomDelivreur(vo.getNomDelivreur());
            if (vo.getCategoriePermisVo() != null && this.categoriePermis)
                item.setCategoriePermis(categoriePermisConverter.toItem(vo.getCategoriePermisVo()));


            return item;
        }
    }

    @Override
    public PermisVo toVo(Permis item) {
        if (item == null) {
            return null;
        } else {
            PermisVo vo = new PermisVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (item.getDateDelivre() != null)
                vo.setDateDelivre(DateUtil.formateDate(item.getDateDelivre()));
//            if (item.getNumberPermis() != null)
//                vo.setNumberPermis(NumberUtil.toString(item.getNumberPermis()));

            if (StringUtil.isNotEmpty(item.getNomDelivreur()))
                vo.setNomDelivreur(item.getNomDelivreur());

            if (item.getCategoriePermis() != null && this.categoriePermis) {
                vo.setCategoriePermisVo(categoriePermisConverter.toVo(item.getCategoriePermis()));
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        categoriePermis = value;
    }


    public CategoriePermisConverter getCategoriePermisConverter() {
        return this.categoriePermisConverter;
    }

    public void setCategoriePermisConverter(CategoriePermisConverter categoriePermisConverter) {
        this.categoriePermisConverter = categoriePermisConverter;
    }

    public boolean isCategoriePermis() {
        return this.categoriePermis;
    }

    public void setCategoriePermis(boolean categoriePermis) {
        this.categoriePermis = categoriePermis;
    }


}
