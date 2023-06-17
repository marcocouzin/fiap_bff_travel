package br.com.fiap.fiap_bff_travel.model;

public class Destination {
    private Integer hotelId;
    private Integer destinationId;
    private String countryId;
    private DestiniesDescriptions name;
    private String type;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public DestiniesDescriptions getName() {
        return name;
    }

    public void setName(DestiniesDescriptions name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Destination() {
        super();
    }
}
