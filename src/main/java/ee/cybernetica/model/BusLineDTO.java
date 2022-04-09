package ee.cybernetica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusLineDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("id")
    private String name;
    @JsonProperty("busStopIds")
    private List<Integer> busStopIds;

    public BusLineDTO(Integer id, String name, List<Integer> busStopIds) {
        this.id = id;
        this.name = name;
        this.busStopIds = busStopIds;
    }

    public BusLineDTO(String name, List<Integer> busStopIds) {
        this.name = name;
        this.busStopIds = busStopIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
