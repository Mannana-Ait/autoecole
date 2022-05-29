package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class MessageVo {

    private String id ;
    private String reference ;
    private String email ;
    private String corps ;
    private String dateEnvoi ;


            private String dateEnvoiMax ;
            private String dateEnvoiMin ;

        private EtatMessageVo etatMessageVo ;


    public MessageVo(){
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
        public String getEmail(){
        return this.email;
        }

        public void setEmail(String email){
        this.email = email;
        }
        public String getCorps(){
        return this.corps;
        }

        public void setCorps(String corps){
        this.corps = corps;
        }
        public String getDateEnvoi(){
        return this.dateEnvoi;
        }

        public void setDateEnvoi(String dateEnvoi){
        this.dateEnvoi = dateEnvoi;
        }


            public String getDateEnvoiMax(){
            return this.dateEnvoiMax;
            }

            public String getDateEnvoiMin(){
            return this.dateEnvoiMin;
            }

            public void setDateEnvoiMax(String dateEnvoiMax){
            this.dateEnvoiMax = dateEnvoiMax;
            }

            public void setDateEnvoiMin(String dateEnvoiMin){
            this.dateEnvoiMin = dateEnvoiMin;
            }


        public EtatMessageVo getEtatMessageVo(){
        return this.etatMessageVo;
        }

        public void setEtatMessageVo(EtatMessageVo etatMessageVo){
        this.etatMessageVo = etatMessageVo;
        }


            }
