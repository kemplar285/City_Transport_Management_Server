package ee.cybernetica.api;

import ee.cybernetica.model.Bus;
import ee.cybernetica.repository.BusRepository;
import ee.cybernetica.service.impl.BusServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-08T12:57:29.477097300+03:00[Europe/Tallinn]")
@Controller
@RequestMapping("${openapi.cityTransport.base-path:}")
public class BusesApiController implements BusesApi {

    private final NativeWebRequest request;
    private BusServiceImpl busService;

    @Autowired
    public BusesApiController(NativeWebRequest request, BusServiceImpl busService) {
        this.request = request;
        this.busService = busService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Bus>> readBuses(){
        List<Bus> buses = busService.getAll();
        return new ResponseEntity(buses, HttpStatus.OK);
    }




}
