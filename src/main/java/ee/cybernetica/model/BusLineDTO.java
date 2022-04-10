package ee.cybernetica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusLineDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("busStopIds")
    private List<Integer> busStopIds;

    public BusLineDTO(String name, List<Integer> busStopIds) {
        this.name = name;
        this.busStopIds = busStopIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getBusStopIds() {
        if(busStopIds == null){
            this.busStopIds = new ArrayList<Integer>();
        }
        return busStopIds;
    }

    public void setBusStopIds(List<Integer> busStopIds) {
        this.busStopIds = busStopIds;
    }
}