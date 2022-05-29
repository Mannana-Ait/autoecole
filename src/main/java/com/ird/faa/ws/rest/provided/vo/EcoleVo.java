package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;

public class EcoleVo {

    private String id ;
    private String reference ;
    private String altitude ;
    private String angitude ;
    private String nom ;
    private String address ;
    private String numAutorisation ;
    private String numFix ;
    private String numPhone ;
    private String email ;
    private String tauxReussite ;
    private String dateCreation ;
    private String dateAbonnement ;


            private String altitudeMax ;
            private String altitudeMin ;
            private String angitudeMax ;
            private String angitudeMin ;
            private String tauxReussiteMax ;
            private String tauxReussiteMin ;
            private String dateCreationMax ;
            private String dateCreationMin ;
            private String dateAbonnementMax ;
            private String dateAbonnementMin ;

        private VilleVo villeVo ;
        private GerantVo gerantVo ;

    private List<VehiculeVo> vehiculesVo ;
    private List<MoniteurTheoriqueVo> moniteurTheoriquesVo ;
    private List<MoniteurPratiqueVo> moniteurPratiquesVo ;
    private List<PlanningItemVo> planningItemsVo ;

    public EcoleVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getReference(){
        return this.reference;
        }

        public void setReference(String reference){
        this.reference = reference;
        }
        public String getAltitude(){
        return this.altitude;
        }

        public void setAltitude(String altitude){
        this.altitude = altitude;
        }
        public String getAngitude(){
        return this.angitude;
        }

        public void setAngitude(String angitude){
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
        public String getTauxReussite(){
        return this.tauxReussite;
        }

        public void setTauxReussite(String tauxReussite){
        this.tauxReussite = tauxReussite;
        }
        public String getDateCreation(){
        return this.dateCreation;
        }

        public void setDateCreation(String dateCreation){
        this.dateCreation = dateCreation;
        }
        public String getDateAbonnement(){
        return this.dateAbonnement;
        }

        public void setDateAbonnement(String dateAbonnement){
        this.dateAbonnement = dateAbonnement;
        }


            public String getAltitudeMax(){
            return this.altitudeMax;
            }

            public String getAltitudeMin(){
            return this.altitudeMin;
            }

            public void setAltitudeMax(String altitudeMax){
            this.altitudeMax = altitudeMax;
            }

            public void setAltitudeMin(String altitudeMin){
            this.altitudeMin = altitudeMin;
            }

            public String getAngitudeMax(){
            return this.angitudeMax;
            }

            public String getAngitudeMin(){
            return this.angitudeMin;
            }

            public void setAngitudeMax(String angitudeMax){
            this.angitudeMax = angitudeMax;
            }

            public void setAngitudeMin(String angitudeMin){
            this.angitudeMin = angitudeMin;
            }

            public String getTauxReussiteMax(){
            return this.tauxReussiteMax;
            }

            public String getTauxReussiteMin(){
            return this.tauxReussiteMin;
            }

            public void setTauxReussiteMax(String tauxReussiteMax){
            this.tauxReussiteMax = tauxReussiteMax;
            }

            public void setTauxReussiteMin(String tauxReussiteMin){
            this.tauxReussiteMin = tauxReussiteMin;
            }

            public String getDateCreationMax(){
            return this.dateCreationMax;
            }

            public String getDateCreationMin(){
            return this.dateCreationMin;
            }

            public void setDateCreationMax(String dateCreationMax){
            this.dateCreationMax = dateCreationMax;
            }

            public void setDateCreationMin(String dateCreationMin){
            this.dateCreationMin = dateCreationMin;
            }

            public String getDateAbonnementMax(){
            return this.dateAbonnementMax;
            }

            public String getDateAbonnementMin(){
            return this.dateAbonnementMin;
            }

            public void setDateAbonnementMax(String dateAbonnementMax){
            this.dateAbonnementMax = dateAbonnementMax;
            }

            public void setDateAbonnementMin(String dateAbonnementMin){
            this.dateAbonnementMin = dateAbonnementMin;
            }


        public VilleVo getVilleVo(){
        return this.villeVo;
        }

        public void setVilleVo(VilleVo villeVo){
        this.villeVo = villeVo;
        }
        public GerantVo getGerantVo(){
        return this.gerantVo;
        }

        public void setGerantVo(GerantVo gerantVo){
        this.gerantVo = gerantVo;
        }


        public List<VehiculeVo> getVehiculesVo(){
        return this.vehiculesVo;
        }

        public void setVehiculesVo(List<VehiculeVo> vehiculesVo){
            this.vehiculesVo = vehiculesVo;
            }

        public List<MoniteurTheoriqueVo> getMoniteurTheoriquesVo(){
        return this.moniteurTheoriquesVo;
        }

        public void setMoniteurTheoriquesVo(List<MoniteurTheoriqueVo> moniteurTheoriquesVo){
            this.moniteurTheoriquesVo = moniteurTheoriquesVo;
            }

        public List<MoniteurPratiqueVo> getMoniteurPratiquesVo(){
        return this.moniteurPratiquesVo;
        }

        public void setMoniteurPratiquesVo(List<MoniteurPratiqueVo> moniteurPratiquesVo){
            this.moniteurPratiquesVo = moniteurPratiquesVo;
            }

        public List<PlanningItemVo> getPlanningItemsVo(){
        return this.planningItemsVo;
        }

        public void setPlanningItemsVo(List<PlanningItemVo> planningItemsVo){
            this.planningItemsVo = planningItemsVo;
            }

            }
