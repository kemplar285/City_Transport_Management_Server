package ee.cybernetica.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * BusLine
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-08T12:36:59.385018700+03:00[Europe/Tallinn]")
public class BusLine   {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("busStopIds")
  @Valid
  private List<Integer> busStopIds = new ArrayList<>();

  public BusLine id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Id given by database, undefined in request body.
   * @return id
  */
  
  @Schema(name = "id", example = "0", description = "Id given by database, undefined in request body.", required = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BusLine name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Bus line name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Kummeli - Ringtee", description = "Bus line name", required = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BusLine busStopIds(List<Integer> busStopIds) {
    this.busStopIds = busStopIds;
    return this;
  }

  public BusLine addBusStopIdsItem(Integer busStopIdsItem) {
    if (this.busStopIds == null) {
      this.busStopIds = new ArrayList<>();
    }
    this.busStopIds.add(busStopIdsItem);
    return this;
  }

  /**
   * Ordered bus stop ids from line start to finish
   * @return busStopIds
  */
  @NotNull 
  @Schema(name = "busStopIds", description = "Ordered bus stop ids from line start to finish", required = true)
  public List<Integer> getBusStopIds() {
    return busStopIds;
  }

  public void setBusStopIds(List<Integer> busStopIds) {
    this.busStopIds = busStopIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusLine busLine = (BusLine) o;
    return Objects.equals(this.id, busLine.id) &&
        Objects.equals(this.name, busLine.name) &&
        Objects.equals(this.busStopIds, busLine.busStopIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, busStopIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusLine {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    busStopIds: ").append(toIndentedString(busStopIds)).append("\n");
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
}

