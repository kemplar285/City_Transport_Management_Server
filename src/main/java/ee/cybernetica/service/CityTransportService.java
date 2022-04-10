package ee.cybernetica.service;

import ee.cybernetica.exception.BusLineNotFoundException;
import ee.cybernetica.exception.BusNotFoundException;
import ee.cybernetica.exception.BusStopNotFoundException;

import java.util.List;

public interface CityTransportService<DTO, ID> {
    DTO add(DTO item);
    void delete(ID id) throws BusNotFoundException;
    DTO getById(ID id) throws BusLineNotFoundException, BusNotFoundException, BusStopNotFoundException;
    DTO edit(DTO item);
    List<DTO> getAll();
}
