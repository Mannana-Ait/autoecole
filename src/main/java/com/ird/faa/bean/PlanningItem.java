package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;


@Entity
@Table(name = "planning_item")
public class PlanningItem {

    @Id
    @SequenceGenerator(name = "planning_item_seq", sequenceName = "planning_item_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planning_item_seq")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOuverture;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateFermeture;

    @ManyToOne
    private Jour jour;

    @ManyToOne
    private Ecole ecole;


    public PlanningItem() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    public Jour getJour() {
        return this.jour;
    }

    public void setJour(Jour jour) {
        this.jour = jour;
    }

    public Date getDateOuverture() {
        return this.dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public Date getDateFermeture() {
        return this.dateFermeture;
    }

    public void setDateFermeture(Date dateFermeture) {
        this.dateFermeture = dateFermeture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanningItem planningItem = (PlanningItem) o;
        return id != null && id.equals(planningItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

