package ee.cybernetica.api;

import ee.cybernetica.exception.BusLineNotFoundException;
import ee.cybernetica.exception.BusNotFoundException;
import ee.cybernetica.model.Bus;
import ee.cybernetica.service.impl.BusLineServiceImpl;
import ee.cybernetica.service.impl.BusServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-08T12:57:29.477097300+03:00[Europe/Tallinn]")
@Controller
@RequestMapping("${openapi.cityTransport.base-path:}")
public class BusesApiController implements BusesApi {

    private final NativeWebRequest request;
    private BusServiceImpl busService;
    private BusLineServiceImpl busLineService;
    private Logger logger = LoggerFactory.getLogger(BusesApiController.class);

    @Autowired
    public BusesApiController(NativeWebRequest request, BusServiceImpl busService, BusLineServiceImpl busLineService) {
        this.request = request;
        this.busService = busService;
        this.busLineService = busLineService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Bus>> readBuses() {
        List<Bus> buses = busService.getAll();
        return new ResponseEntity(buses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Bus> createBus(@Valid @RequestBody(required = false) Bus bus) throws BusLineNotFoundException {
            Bus busToSave = new Bus();
            busToSave.setBusLineId(bus.getBusLineId());
            busToSave.setLicenceNumber(bus.getLicenceNumber());
            busToSave.setBusLine(busLineService.getById(bus.getBusLineId()));
            busToSave = busService.add(busToSave);
            return new ResponseEntity<Bus>(busToSave, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Bus> updateBus(@PathVariable("busId") Integer busId
            ,@Valid @RequestBody(required = true) Bus bus) throws BusNotFoundException, BusLineNotFoundException {
        Bus busFound = busService.getById(busId);
        busFound.setBusLine(busLineService.getById(bus.getBusLineId()));
        busFound.setBusLineId(bus.getBusLineId());
        busFound.setLicenceNumber(bus.getLicenceNumber());
        busFound = busService.edit(busFound);
        return new ResponseEntity<>(bus, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteBus(@PathVariable("busId") Integer busId) throws BusNotFoundException {
        busService.delete(busId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
