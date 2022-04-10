package ee.cybernetica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class BusStopTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "line_id")
    @JsonIgnore
    BusLine busLine;

    @ManyToOne
    @JoinColumn(name = "stop_id")
    @JsonProperty("stop_id")
    BusStop busStop;

    @JsonProperty("time")
    LocalTime time;

    public BusStopTime() {
    }

    public BusStopTime(BusLine busLine, BusStop busStop, LocalTime time) {
        this.busLine = busLine;
        this.busStop = busStop;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BusLine getBusLine() {
        return busLine;
    }

    public void setBusLine(BusLine busLine) {
        this.busLine = busLine;
    }

    public BusStop getBusStop() {
        return busStop;
    }

    public void setBusStop(BusStop busStop) {
        this.busStop = busStop;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
