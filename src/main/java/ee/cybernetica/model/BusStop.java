package ee.cybernetica.model;

import java.net.URI;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.OffsetDateTime;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * BusStop
 */
@Entity
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-08T12:57:29.477097300+03:00[Europe/Tallinn]")
public class BusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    @Column(name = "stop_id")
    private Integer id;

    @NotNull
    @JsonProperty("name")
    private String name;
    @NotNull
    @JsonProperty("latitude")
    private String latitude;

    @NotNull
    @JsonProperty("longitude")
    private String longitude;

    public BusStop id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Id given by database, undefined in request body.
     *
     * @return id
     */

    @Schema(name = "id", example = "0", description = "Id given by database, undefined in request body.", required = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Name of bus stop
     *
     * @return name
     */
    @NotNull
    @Schema(name = "name", example = "Vene", description = "Name of bus stop", required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * Bus stop location latitude
     *
     * @return latitude
     */
    @NotNull
    @Schema(name = "latitude", example = "58.385787", description = "Bus stop location latitude", required = true)
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Bus stop location latitude
     *
     * @return longitude
     */
    @NotNull
    @Schema(name = "longitude", example = "26.726408", description = "Bus stop location latitude", required = true)
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BusStop busStop = (BusStop) o;
        return Objects.equals(this.id, busStop.id) &&
                Objects.equals(this.name, busStop.name) &&
                Objects.equals(this.latitude, busStop.latitude) &&
                Objects.equals(this.longitude, busStop.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BusStop {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
        sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
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

