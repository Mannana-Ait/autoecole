package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "vehicule")
public class Vehicule   {

@Id
    @SequenceGenerator(name="vehicule_seq",sequenceName="vehicule_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vehicule_seq")
private Long id;

            @Column(length = 500)
            private String matricule;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateAchatVehicule ;
            @Column(length = 500)
            private String imageUrl;

    @ManyToOne
    private Marque marque ;
    @ManyToOne
    private TypeVehicule typeVehicule ;
    @ManyToOne
    private Ecole ecole ;


public Vehicule(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getMatricule(){
            return this.matricule;
            }
            public void setMatricule(String matricule){
            this.matricule = matricule;
            }
            public Marque getMarque(){
            return this.marque;
            }
            public void setMarque(Marque marque){
            this.marque = marque;
            }
            public TypeVehicule getTypeVehicule(){
            return this.typeVehicule;
            }
            public void setTypeVehicule(TypeVehicule typeVehicule){
            this.typeVehicule = typeVehicule;
            }
            public Date getDateAchatVehicule(){
            return this.dateAchatVehicule;
            }
            public void setDateAchatVehicule(Date dateAchatVehicule){
            this.dateAchatVehicule = dateAchatVehicule;
            }
            public String getImageUrl(){
            return this.imageUrl;
            }
            public void setImageUrl(String imageUrl){
            this.imageUrl = imageUrl;
            }
            public Ecole getEcole(){
            return this.ecole;
            }
            public void setEcole(Ecole ecole){
            this.ecole = ecole;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return id != null && id.equals(vehicule.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

