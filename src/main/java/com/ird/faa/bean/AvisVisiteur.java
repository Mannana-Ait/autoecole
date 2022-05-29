package com.ird.faa.bean;

import java.util.Objects;



    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "avis_visiteur")
public class AvisVisiteur   {

@Id
    @SequenceGenerator(name="avis_visiteur_seq",sequenceName="avis_visiteur_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="avis_visiteur_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String emailVisiteur;
            @Column(length = 500)
            private String objet;
            @Lob
            @Column(columnDefinition="TEXT")
            private String message;
            private BigDecimal ratting ;

    @ManyToOne
    private TypeAvis typeAvis ;


public AvisVisiteur(){
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
            public String getEmailVisiteur(){
            return this.emailVisiteur;
            }
            public void setEmailVisiteur(String emailVisiteur){
            this.emailVisiteur = emailVisiteur;
            }
            public String getObjet(){
            return this.objet;
            }
            public void setObjet(String objet){
            this.objet = objet;
            }
            public String getMessage(){
            return this.message;
            }
            public void setMessage(String message){
            this.message = message;
            }
            public BigDecimal getRatting(){
            return this.ratting;
            }
            public void setRatting(BigDecimal ratting){
            this.ratting = ratting;
            }
            public TypeAvis getTypeAvis(){
            return this.typeAvis;
            }
            public void setTypeAvis(TypeAvis typeAvis){
            this.typeAvis = typeAvis;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvisVisiteur avisVisiteur = (AvisVisiteur) o;
        return id != null && id.equals(avisVisiteur.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

