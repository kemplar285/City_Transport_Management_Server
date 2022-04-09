package ee.cybernetica.service.impl;

import ee.cybernetica.model.Bus;
import ee.cybernetica.model.BusLine;
import ee.cybernetica.repository.BusLineRepository;
import ee.cybernetica.service.CityTransportService;

import java.util.List;

public class BusLineServiceImpl implements CityTransportService<BusLine, Integer> {
    private BusLineRepository busLineRepository;

    public BusLineServiceImpl(BusLineRepository busLineRepository) {
        this.busLineRepository = busLineRepository;
    }

    @Override
    public BusLine add(BusLine item) {
        BusLine saved = busLineRepository.saveAndFlush(item);
        return saved;
    }

    @Override
    public void delete(Integer id) {
        busLineRepository.deleteById(id);
    }

    @Override
    public BusLine getById(Integer id) {
        return busLineRepository.findById(id).orElse(null);
    }

    @Override
    public BusLine edit(BusLine item) {
        return busLineRepository.saveAndFlush(item);
    }

    @Override
    public List<BusLine> getAll() {
        return busLineRepository.findAll();
    }
}
