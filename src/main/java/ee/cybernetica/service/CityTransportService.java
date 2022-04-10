package ee.cybernetica.service;

import ee.cybernetica.exception.BusLineNotFound;
import ee.cybernetica.exception.BusNotFound;

import java.util.List;

public interface CityTransportService<DTO, ID> {
    DTO add(DTO item);
    void delete(ID id) throws BusNotFound;
    DTO getById(ID id) throws BusLineNotFound, BusNotFound;
    DTO edit(DTO item);
    List<DTO> getAll();
}
