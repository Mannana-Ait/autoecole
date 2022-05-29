package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "gerant")
public class Gerant   {

@Id
    @SequenceGenerator(name="gerant_seq",sequenceName="gerant_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="gerant_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String nom;
            @Column(length = 500)
            private String prenom;
            @Column(length = 500)
            private String email;
            @Column(length = 500)
            private String adress;
            @Column(length = 500)
            private String phone;
            @Column(length = 500)
            private String fix;
            @Column(length = 500)
            private String lieuNaissance;
            @Column(length = 500)
            private String dateNaissance;
            @Column(length = 500)
            private String cin;
            @Column(length = 500)
            private String picture;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateJoin ;

    @ManyToOne
    private Gender gender ;


public Gerant(){
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
            public String getNom(){
            return this.nom;
            }
            public void setNom(String nom){
            this.nom = nom;
            }
            public String getPrenom(){
            return this.prenom;
            }
            public void setPrenom(String prenom){
            this.prenom = prenom;
            }
            public String getEmail(){
            return this.email;
            }
            public void setEmail(String email){
            this.email = email;
            }
            public String getAdress(){
            return this.adress;
            }
            public void setAdress(String adress){
            this.adress = adress;
            }
            public String getPhone(){
            return this.phone;
            }
            public void setPhone(String phone){
            this.phone = phone;
            }
            public String getFix(){
            return this.fix;
            }
            public void setFix(String fix){
            this.fix = fix;
            }
            public String getLieuNaissance(){
            return this.lieuNaissance;
            }
            public void setLieuNaissance(String lieuNaissance){
            this.lieuNaissance = lieuNaissance;
            }
            public String getDateNaissance(){
            return this.dateNaissance;
            }
            public void setDateNaissance(String dateNaissance){
            this.dateNaissance = dateNaissance;
            }
            public String getCin(){
            return this.cin;
            }
            public void setCin(String cin){
            this.cin = cin;
            }
            public Gender getGender(){
            return this.gender;
            }
            public void setGender(Gender gender){
            this.gender = gender;
            }
            public String getPicture(){
            return this.picture;
            }
            public void setPicture(String picture){
            this.picture = picture;
            }
            public Date getDateJoin(){
            return this.dateJoin;
            }
            public void setDateJoin(Date dateJoin){
            this.dateJoin = dateJoin;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gerant gerant = (Gerant) o;
        return id != null && id.equals(gerant.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

