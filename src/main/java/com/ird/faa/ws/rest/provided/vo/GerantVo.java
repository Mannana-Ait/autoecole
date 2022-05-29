package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class GerantVo {

    private String id ;
    private String reference ;
    private String nom ;
    private String prenom ;
    private String email ;
    private String adress ;
    private String phone ;
    private String fix ;
    private String lieuNaissance ;
    private String dateNaissance ;
    private String cin ;
    private String picture ;
    private String dateJoin ;


            private String dateJoinMax ;
            private String dateJoinMin ;

        private GenderVo genderVo ;


    public GerantVo(){
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
        public String getPicture(){
        return this.picture;
        }

        public void setPicture(String picture){
        this.picture = picture;
        }
        public String getDateJoin(){
        return this.dateJoin;
        }

        public void setDateJoin(String dateJoin){
        this.dateJoin = dateJoin;
        }


            public String getDateJoinMax(){
            return this.dateJoinMax;
            }

            public String getDateJoinMin(){
            return this.dateJoinMin;
            }

            public void setDateJoinMax(String dateJoinMax){
            this.dateJoinMax = dateJoinMax;
            }

            public void setDateJoinMin(String dateJoinMin){
            this.dateJoinMin = dateJoinMin;
            }


        public GenderVo getGenderVo(){
        return this.genderVo;
        }

        public void setGenderVo(GenderVo genderVo){
        this.genderVo = genderVo;
        }


            }
