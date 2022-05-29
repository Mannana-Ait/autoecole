package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "message")
public class Message   {

@Id
    @SequenceGenerator(name="message_seq",sequenceName="message_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="message_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String email;
            @Lob
            @Column(columnDefinition="TEXT")
            private String corps;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateEnvoi ;

    @ManyToOne
    private EtatMessage etatMessage ;


public Message(){
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
            public Date getDateEnvoi(){
            return this.dateEnvoi;
            }
            public void setDateEnvoi(Date dateEnvoi){
            this.dateEnvoi = dateEnvoi;
            }
            public EtatMessage getEtatMessage(){
            return this.etatMessage;
            }
            public void setEtatMessage(EtatMessage etatMessage){
            this.etatMessage = etatMessage;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id != null && id.equals(message.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

