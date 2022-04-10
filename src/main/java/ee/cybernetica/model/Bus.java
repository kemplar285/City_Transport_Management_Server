package ee.cybernetica.model;

import java.net.URI;
import java.util.Objects;

import com.fasterxml.jackson.annotation.*;

import java.time.OffsetDateTime;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Bus
 */
@Entity
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-08T12:57:29.477097300+03:00[Europe/Tallinn]")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bus   {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("licenceNumber")
  @NotNull
  private String licenceNumber;

  @ManyToOne
  @JoinColumn(name = "line_id")
  @JsonIgnore
  private BusLine busLine;

  @JsonProperty("busLineId")
  @Transient
  private Integer busLineId;

  public Bus id(Integer id) {
    this.id = id;
    return this;
  }

  @PostLoad
  private void postLoad() {
    this.busLineId = busLine.getId();
  }

  public Bus() {
  }

  public Bus(Integer id, String licenceNumber, Integer busLineId) {
    this.id = id;
    this.licenceNumber = licenceNumber;
    this.busLineId = busLineId;
  }

  /**
   * Id given by database, undefined in request body.
   * @return id
  */
  
  @Schema(name = "id", example = "0", description = "Id given by database, undefined in request body.", required = false)
  public Integer getId() {
    return id;
  }

  /**
   * Licence plate number
   * @return licenceNumber
  */
  @NotNull 
  @Schema(name = "licenceNumber", example = "460TNP", description = "Licence plate number", required = true)
  public String getLicenceNumber() {
    return licenceNumber;
  }

  public void setLicenceNumber(String licenceNumber) {
    this.licenceNumber = licenceNumber;
  }

  public void setBusLine(BusLine busLine){
      this.busLine = busLine;
  }

  /**
   * Bus line which bus is serving.
   * @return busLineId
  */
  
  @Schema(name = "busLineId", example = "0", description = "Bus line which bus is serving.", required = false)
  public Integer getBusLineId() {
    return busLineId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bus bus = (Bus) o;
    return Objects.equals(this.id, bus.id) &&
        Objects.equals(this.licenceNumber, bus.licenceNumber) &&
        Objects.equals(this.busLineId, bus.busLineId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, licenceNumber, busLineId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bus {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    licenceNumber: ").append(toIndentedString(licenceNumber)).append("\n");
    sb.append("    busLineId: ").append(toIndentedString(busLineId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public void setBusLineId(Integer busLineId) {
    this.busLineId = busLineId;
  }
}

