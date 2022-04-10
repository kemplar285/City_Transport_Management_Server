package ee.cybernetica.service.impl;

import ee.cybernetica.exception.BusStopNotFoundException;
import ee.cybernetica.model.BusLine;
import ee.cybernetica.model.BusStop;
import ee.cybernetica.repository.BusLineRepository;
import ee.cybernetica.repository.BusStopRepository;
import ee.cybernetica.service.CityTransportService;
import io.swagger.models.auth.In;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusStopServiceImpl implements CityTransportService<BusStop, Integer> {
    private final BusStopRepository busStopRepository;
    private final BusLineRepository busLineRepository;
    private final BusLineServiceImpl busLineService;

    public BusStopServiceImpl(BusStopRepository busStopRepository, BusLineRepository busLineRepository, BusLineServiceImpl busLineService) {
        this.busStopRepository = busStopRepository;
        this.busLineRepository = busLineRepository;
        this.busLineService = busLineService;
    }

    @Override
    public BusStop add(BusStop item) {
        BusStop saved = busStopRepository.saveAndFlush(item);
        return saved;
    }

    @Override
    public void delete(Integer id) {
        List<BusLine> busLines = busLineService.getAllWithBusStopIdInBusStopIds(id);
        busLines.forEach(busLine -> {
            busLine.removeFromBusStopIds(id);
            busLineService.edit(busLine);
        });
        busStopRepository.deleteById(id);
    }

    @Override
    public BusStop getById(Integer id) throws BusStopNotFoundException {
        return busStopRepository.findById(id).orElseThrow(() -> new BusStopNotFoundException("Bus stop not found"));
    }

    @Override
    public BusStop edit(BusStop item) {
        return busStopRepository.saveAndFlush(item);
    }

    @Override
    public List<BusStop> getAll() {
        return busStopRepository.findAll();
    }

    public List<BusStop> getAllByNameWithLimit(String name, Integer limit) {
        Pageable pageRequest = PageRequest.of(0, limit);
        if (name == null) {
            return busStopRepository.findAllWithLimit(pageRequest);
        }
        return busStopRepository.findAllByNameWithLimit(name, pageRequest);
    }
}
