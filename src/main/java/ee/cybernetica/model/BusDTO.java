package ee.cybernetica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("licenceNumber")
    private String licenceNumber;
    @JsonProperty("busLineId")
    private Integer busLineId;

    public BusDTO(Integer id, String licenceNumber, Integer busLineId) {
        this.id = id;
        this.licenceNumber = licenceNumber;
        this.busLineId = busLineId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public Integer getBusLineId() {
        return busLineId;
    }

    public void setBusLineId(Integer busLineId) {
        this.busLineId = busLineId;
    }
}
