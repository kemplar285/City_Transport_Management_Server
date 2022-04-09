package ee.cybernetica.service.impl;

import ee.cybernetica.model.Bus;
import ee.cybernetica.model.BusStop;
import ee.cybernetica.repository.BusStopRepository;
import ee.cybernetica.service.CityTransportService;

import java.util.List;

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
    public BusStop getById(Integer id) {
        return busStopRepository.findById(id).orElse(null);
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
