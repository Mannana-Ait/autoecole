package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "type_vehicule")
public class TypeVehicule   {

@Id
    @SequenceGenerator(name="type_vehicule_seq",sequenceName="type_vehicule_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="type_vehicule_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String libele;



public TypeVehicule(){
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

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeVehicule typeVehicule = (TypeVehicule) o;
        return id != null && id.equals(typeVehicule.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

