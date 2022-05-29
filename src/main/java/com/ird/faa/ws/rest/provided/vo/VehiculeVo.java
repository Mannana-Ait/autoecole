package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class VehiculeVo {

    private String id ;
    private String matricule ;
    private String dateAchatVehicule ;
    private String imageUrl ;


            private String dateAchatVehiculeMax ;
            private String dateAchatVehiculeMin ;

        private MarqueVo marqueVo ;
        private TypeVehiculeVo typeVehiculeVo ;
        private EcoleVo ecoleVo ;


    public VehiculeVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getMatricule(){
        return this.matricule;
        }

        public void setMatricule(String matricule){
        this.matricule = matricule;
        }
        public String getDateAchatVehicule(){
        return this.dateAchatVehicule;
        }

        public void setDateAchatVehicule(String dateAchatVehicule){
        this.dateAchatVehicule = dateAchatVehicule;
        }
        public String getImageUrl(){
        return this.imageUrl;
        }

        public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
        }


            public String getDateAchatVehiculeMax(){
            return this.dateAchatVehiculeMax;
            }

            public String getDateAchatVehiculeMin(){
            return this.dateAchatVehiculeMin;
            }

            public void setDateAchatVehiculeMax(String dateAchatVehiculeMax){
            this.dateAchatVehiculeMax = dateAchatVehiculeMax;
            }

            public void setDateAchatVehiculeMin(String dateAchatVehiculeMin){
            this.dateAchatVehiculeMin = dateAchatVehiculeMin;
            }


        public MarqueVo getMarqueVo(){
        return this.marqueVo;
        }

        public void setMarqueVo(MarqueVo marqueVo){
        this.marqueVo = marqueVo;
        }
        public TypeVehiculeVo getTypeVehiculeVo(){
        return this.typeVehiculeVo;
        }

        public void setTypeVehiculeVo(TypeVehiculeVo typeVehiculeVo){
        this.typeVehiculeVo = typeVehiculeVo;
        }
        public EcoleVo getEcoleVo(){
        return this.ecoleVo;
        }

        public void setEcoleVo(EcoleVo ecoleVo){
        this.ecoleVo = ecoleVo;
        }


            }
