package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "ecole")
public class Ecole   {

@Id
    @SequenceGenerator(name="ecole_seq",sequenceName="ecole_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="ecole_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            private BigDecimal altitude ;
            private BigDecimal angitude ;
            @Column(length = 500)
            private String nom;
            @Lob
            @Column(columnDefinition="TEXT")
            private String address;
            @Column(length = 500)
            private String numAutorisation;
            @Column(length = 500)
            private String numFix;
            @Column(length = 500)
            private String numPhone;
            @Column(length = 500)
            private String email;
            private BigDecimal tauxReussite ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCreation ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateAbonnement ;

    @ManyToOne
    private Ville ville ;
    @ManyToOne
    private Gerant gerant ;

                @OneToMany(mappedBy = "ecole")
            private List<Vehicule> vehicules ;
                @OneToMany
            private List<MoniteurTheorique> moniteurTheoriques ;
                @OneToMany
            private List<MoniteurPratique> moniteurPratiques ;
                @OneToMany
            private List<PlanningItem> planningItems ;

public Ecole(){
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
            public Ville getVille(){
            return this.ville;
            }
            public void setVille(Ville ville){
            this.ville = ville;
            }
            public BigDecimal getAltitude(){
            return this.altitude;
            }
            public void setAltitude(BigDecimal altitude){
            this.altitude = altitude;
            }
            public BigDecimal getAngitude(){
            return this.angitude;
            }
            public void setAngitude(BigDecimal angitude){
            this.angitude = angitude;
            }
            public String getNom(){
            return this.nom;
            }
            public void setNom(String nom){
            this.nom = nom;
            }
            public String getAddress(){
            return this.address;
            }
            public void setAddress(String address){
            this.address = address;
            }
            public String getNumAutorisation(){
            return this.numAutorisation;
            }
            public void setNumAutorisation(String numAutorisation){
            this.numAutorisation = numAutorisation;
            }
            public String getNumFix(){
            return this.numFix;
            }
            public void setNumFix(String numFix){
            this.numFix = numFix;
            }
            public String getNumPhone(){
            return this.numPhone;
            }
            public void setNumPhone(String numPhone){
            this.numPhone = numPhone;
            }
            public String getEmail(){
            return this.email;
            }
            public void setEmail(String email){
            this.email = email;
            }
            public BigDecimal getTauxReussite(){
            return this.tauxReussite;
            }
            public void setTauxReussite(BigDecimal tauxReussite){
            this.tauxReussite = tauxReussite;
            }
            public Date getDateCreation(){
            return this.dateCreation;
            }
            public void setDateCreation(Date dateCreation){
            this.dateCreation = dateCreation;
            }
            public Date getDateAbonnement(){
            return this.dateAbonnement;
            }
            public void setDateAbonnement(Date dateAbonnement){
            this.dateAbonnement = dateAbonnement;
            }
            public Gerant getGerant(){
            return this.gerant;
            }
            public void setGerant(Gerant gerant){
            this.gerant = gerant;
            }
            public List<Vehicule> getVehicules(){
            return this.vehicules;
            }
            public void setVehicules(List<Vehicule> vehicules){
            this.vehicules = vehicules;
            }
            public List<MoniteurTheorique> getMoniteurTheoriques(){
            return this.moniteurTheoriques;
            }
            public void setMoniteurTheoriques(List<MoniteurTheorique> moniteurTheoriques){
            this.moniteurTheoriques = moniteurTheoriques;
            }
            public List<MoniteurPratique> getMoniteurPratiques(){
            return this.moniteurPratiques;
            }
            public void setMoniteurPratiques(List<MoniteurPratique> moniteurPratiques){
            this.moniteurPratiques = moniteurPratiques;
            }
            public List<PlanningItem> getPlanningItems(){
            return this.planningItems;
            }
            public void setPlanningItems(List<PlanningItem> planningItems){
            this.planningItems = planningItems;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ecole ecole = (Ecole) o;
        return id != null && id.equals(ecole.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

