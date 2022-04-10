package ee.cybernetica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.Cascade;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * BusLine
 */
@Entity
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-08T12:57:29.477097300+03:00[Europe/Tallinn]")
public class BusLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "line_id")
    private Integer id;

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @OneToMany(mappedBy = "busLine", targetEntity = BusStopTime.class, cascade = CascadeType.ALL)
    @JsonProperty("busStopTimes")
    private List<BusStopTime> busStops = new ArrayList<>();

    public BusLine id(Integer id) {
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

    public BusLine name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Bus line name
     *
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

    public BusLine addBusStop(BusStop busStop, LocalTime time) {
        if (this.busStops == null) {
            this.busStops = new ArrayList<>();
        }
        this.busStops.add(new BusStopTime(this, busStop, time));
        return this;
    }

    /**
     * Ordered bus stop ids from line start to finish
     *
     * @return busStopIds
     */
    @NotNull
    @Schema(name = "busStopIds", description = "Ordered bus stop ids from line start to finish", required = true)

    public List<Integer> getBusStopIds() {
        if (busStops != null) {
            return busStops.stream().map(m->m.getBusStop().getId()).sorted().collect(Collectors.toList());
        }
        return new ArrayList<>();

    }

    public List<BusStopTime> getBusStops() {
        return busStops;
    }



    /**
     * Delete all busStops with specified id
     * @param id bus stop id
     */
    public void removeFromBusStopIds(Integer id){
        //busStops.keys().removeIf(s -> s.getId().equals(id));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, busStops);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BusLine {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    busStopIds: ").append(toIndentedString(busStops)).append("\n");
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

