package ee.cybernetica.api;

import ee.cybernetica.model.BusLine;
import ee.cybernetica.model.BusStop;
import ee.cybernetica.service.impl.BusLineServiceImpl;
import ee.cybernetica.service.impl.BusStopServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-08T12:57:29.477097300+03:00[Europe/Tallinn]")
@Controller
@RequestMapping("${openapi.cityTransport.base-path:}")
public class BusStopsApiController implements BusStopsApi {
    private final NativeWebRequest request;
    private BusLineServiceImpl busLineService;
    private BusStopServiceImpl busStopService;

    @Autowired
    public BusStopsApiController(NativeWebRequest request, BusStopServiceImpl busStopService, BusLineServiceImpl busLineService) {
        this.request = request;
        this.busLineService = busLineService;
        this.busStopService = busStopService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<BusStop>> readBusStops(
            @Min(1) @Max(50) @Valid @RequestParam(value = "maxResults", required = false, defaultValue = "20") Integer maxResults,
            @Valid @RequestParam(value = "name", required = false) String name
    ) {
        return new ResponseEntity<>(busStopService.getAllByNameWithLimit(name, maxResults), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BusStop> createBusStop( @Valid @RequestBody(required = false) BusStop busStop){
        BusStop savedStop = new BusStop();
        if (busStop != null) {
            savedStop.setName(busStop.getName());
            savedStop.setLongitude(busStop.getLongitude());
            savedStop.setLatitude(busStop.getLatitude());
        }
        return new ResponseEntity<>(busStopService.add(savedStop), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteBusStop(@Valid @PathVariable(value = "id", required = true) Integer id){
        busStopService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
