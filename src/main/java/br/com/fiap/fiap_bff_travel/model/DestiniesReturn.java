package br.com.fiap.fiap_bff_travel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DestiniesReturn {
    @JsonProperty("type")
    String type;

    @JsonProperty("subgroup")
    List<Destination> destynies;

    public DestiniesReturn(String type, List<Destination> destynies) {
        this.type = type;
        this.destynies = destynies;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Destination> getDestynies() {
        return destynies;
    }

    public void setDestynies(List<Destination> destynies) {
        this.destynies = destynies;
    }
}
