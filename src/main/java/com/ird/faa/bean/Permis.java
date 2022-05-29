package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "permis")
public class Permis   {

@Id
    @SequenceGenerator(name="permis_seq",sequenceName="permis_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="permis_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateDelivre ;
            private Integer numberPermis;
            @Column(length = 500)
            private String nomDelivreur;

    @ManyToOne
    private CategoriePermis categoriePermis ;


public Permis(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getReference(){
            return this.reference;
            }
            public void setReference(String reference){
            this.reference = reference;
            }
            public Date getDateDelivre(){
            return this.dateDelivre;
            }
            public void setDateDelivre(Date dateDelivre){
            this.dateDelivre = dateDelivre;
            }
            public int getNumberPermis(){
            return this.numberPermis;
            }
            public void setNumberPermis(int numberPermis){
            this.numberPermis = numberPermis;
            }
            public String getNomDelivreur(){
            return this.nomDelivreur;
            }
            public void setNomDelivreur(String nomDelivreur){
            this.nomDelivreur = nomDelivreur;
            }
            public CategoriePermis getCategoriePermis(){
            return this.categoriePermis;
            }
            public void setCategoriePermis(CategoriePermis categoriePermis){
            this.categoriePermis = categoriePermis;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permis permis = (Permis) o;
        return id != null && id.equals(permis.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

