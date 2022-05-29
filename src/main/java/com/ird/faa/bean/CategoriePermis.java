package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "categorie_permis")
public class CategoriePermis   {

@Id
    @SequenceGenerator(name="categorie_permis_seq",sequenceName="categorie_permis_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="categorie_permis_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String libele;
            @Lob
            @Column(columnDefinition="TEXT")
            private String description;



public CategoriePermis(){
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
            public String getLibele(){
            return this.libele;
            }
            public void setLibele(String libele){
            this.libele = libele;
            }
            public String getDescription(){
            return this.description;
            }
            public void setDescription(String description){
            this.description = description;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriePermis categoriePermis = (CategoriePermis) o;
        return id != null && id.equals(categoriePermis.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

