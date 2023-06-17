package br.com.fiap.fiap_bff_travel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DestiniesDescriptions {
    private String en;
    private String es;
    @JsonProperty("pt-BR")
    private String ptBR;
    private String other;

    public DestiniesDescriptions() {
        super();
    }

    public String getEn() {
        return en;
    }
    public void setEn(String en) {
        this.en = en;
    }
    public String getEs() {
        return es;
    }
    public void setEs(String es) {
        this.es = es;
    }
    public String getPtBR() {
        return ptBR;
    }
    public void setPtBR(String ptBR) {
        this.ptBR = ptBR;
    }
    public String getOther() {
        return other;
    }
    public void setOther(String other) {
        this.other = other;
    }
}
