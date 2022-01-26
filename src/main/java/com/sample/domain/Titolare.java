package com.sample.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Titolare implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TIT")
    private Long idTitolare;

    @Column(name = "TITOLARE")
    private String titolare;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "UTENTE_APP")
    private String utenteUltimaModifica;

    @Column(name = "DATA_INSERIMENTO")
    private String dataInserimento;

    @Column(name = "DATA_AGGIORNAMENTO")
    private String dataAggiornamento;

    public Long getIdTitolare() {
        return idTitolare;
    }

    public void setIdTitolare(Long idTitolare) {
        this.idTitolare = idTitolare;
    }

    public String getTitolare() {
        return titolare;
    }

    public void setTitolare(String titolare) {
        this.titolare = titolare;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUtenteUltimaModifica() {
        return utenteUltimaModifica;
    }

    public void setUtenteUltimaModifica(String utenteUltimaModifica) {
        this.utenteUltimaModifica = utenteUltimaModifica;
    }

    public String getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(String dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public String getDataAggiornamento() {
        return dataAggiornamento;
    }

    public void setDataAggiornamento(String dataAggiornamento) {
        this.dataAggiornamento = dataAggiornamento;
    }

    @Override
    public String toString() {
        return "Titolare{" +
                "idTitolare=" + idTitolare +
                ", titolare='" + titolare + '\'' +
                ", note=" + note +
                ", utenteUltimaModifica='" + utenteUltimaModifica + '\'' +
                ", dataInserimento='" + dataInserimento + '\'' +
                ", dataAggiornamento='" + dataAggiornamento + '\'' +
                '}';
    }
}
