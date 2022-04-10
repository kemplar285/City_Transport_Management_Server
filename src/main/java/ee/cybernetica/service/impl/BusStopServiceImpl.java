package ee.cybernetica.service.impl;

import ee.cybernetica.exception.BusStopNotFoundException;
import ee.cybernetica.model.BusStop;
import ee.cybernetica.repository.BusStopRepository;
import ee.cybernetica.service.CityTransportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusStopServiceImpl implements CityTransportService<BusStop, Integer> {
    private BusStopRepository busStopRepository;

    public BusStopServiceImpl(BusStopRepository busStopRepository) {
        this.busStopRepository = busStopRepository;
    }

    @Override
    public BusStop add(BusStop item) {
        BusStop saved = busStopRepository.saveAndFlush(item);
        return saved;
    }

    @Override
    public void delete(Integer id) {
        busStopRepository.deleteById(id);
    }

    @Override
    public BusStop getById(Integer id) throws BusStopNotFoundException {
        return busStopRepository.findById(id).orElseThrow(()->new BusStopNotFoundException("Bus stop not found"));
    }

    @Override
    public BusStop edit(BusStop item) {
        return busStopRepository.saveAndFlush(item);
    }

    @Override
    public List<BusStop> getAll() {
        return busStopRepository.findAll();
    }
}
