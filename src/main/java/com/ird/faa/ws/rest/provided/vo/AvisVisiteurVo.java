package  com.ird.faa.ws.rest.provided.vo;

    import java.math.BigDecimal;

public class AvisVisiteurVo {

    private String id ;
    private String reference ;
    private String emailVisiteur ;
    private String objet ;
    private String message ;
    private String ratting ;


            private String rattingMax ;
            private String rattingMin ;

        private TypeAvisVo typeAvisVo ;


    public AvisVisiteurVo(){
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
        public String getRatting(){
        return this.ratting;
        }

        public void setRatting(String ratting){
        this.ratting = ratting;
        }


            public String getRattingMax(){
            return this.rattingMax;
            }

            public String getRattingMin(){
            return this.rattingMin;
            }

            public void setRattingMax(String rattingMax){
            this.rattingMax = rattingMax;
            }

            public void setRattingMin(String rattingMin){
            this.rattingMin = rattingMin;
            }


        public TypeAvisVo getTypeAvisVo(){
        return this.typeAvisVo;
        }

        public void setTypeAvisVo(TypeAvisVo typeAvisVo){
        this.typeAvisVo = typeAvisVo;
        }


            }
