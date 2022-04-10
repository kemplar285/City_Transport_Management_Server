package ee.cybernetica.api;

import ee.cybernetica.exception.BusStopNotFoundException;
import ee.cybernetica.model.BusLine;
import ee.cybernetica.model.BusLineDTO;
import ee.cybernetica.service.impl.BusLineServiceImpl;
import ee.cybernetica.service.impl.BusStopServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-08T12:57:29.477097300+03:00[Europe/Tallinn]")
@Controller
@RequestMapping("${openapi.cityTransport.base-path:}")
public class BusLinesApiController implements BusLinesApi {

    private final NativeWebRequest request;
    private BusLineServiceImpl busLineService;
    private BusStopServiceImpl busStopService;

    public BusLinesApiController(NativeWebRequest request, BusLineServiceImpl busLineService, BusStopServiceImpl busStopService) {
        this.request = request;
        this.busLineService = busLineService;
        this.busStopService = busStopService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<BusLine>> readBusLines(
            @Min(1) @Max(50) @Valid @RequestParam(value = "maxResults", required = false, defaultValue = "20") Integer maxResults,
            @Valid @RequestParam(value = "name", required = false) Optional<String> name,
            @Valid @RequestParam(value = "busStopId", required = false) Optional<Integer> busStopId
    ) {
        List<BusLine> lines = busLineService.getAllWithLimit(maxResults);
        if (name.isPresent()) {
            lines = lines.stream().filter(m -> m.getName().equals(name.get()))
                    .collect(Collectors.toList());
        }
        if (busStopId.isPresent()) {
            lines = lines.stream().filter(m -> m.getBusStopIds().contains(busStopId.get()))
                    .collect(Collectors.toList());
        }
        return new ResponseEntity<>(lines, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BusLine> createBusLine(@Valid @RequestBody(required = false) BusLineDTO busLine) throws BusStopNotFoundException {
        BusLine savedLine = new BusLine();
        if (busLine != null) {
            savedLine.setName(busLine.getName());
            for(Integer id : busLine.getBusStopIds()){
                savedLine.addBusStop(busStopService.getById(id));
            }
        }
        return new ResponseEntity<>(busLineService.add(savedLine), HttpStatus.OK);
    }


}
