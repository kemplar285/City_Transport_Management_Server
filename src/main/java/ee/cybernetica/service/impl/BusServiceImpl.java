package ee.cybernetica.service.impl;

import ee.cybernetica.model.Bus;
import ee.cybernetica.repository.BusRepository;
import ee.cybernetica.service.CityTransportService;

import java.util.List;

public class BusServiceImpl implements CityTransportService<Bus, Integer> {
    private final BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Bus add(Bus bus) {
        Bus saved = busRepository.saveAndFlush(bus);
        return saved;
    }

    @Override
    public void delete(Integer id) {
        busRepository.deleteById(id);
    }

    @Override
    public Bus getById(Integer id) {
        return busRepository.findById(id).orElse(null);
    }

    @Override
    public Bus edit(Bus bus) {
        return busRepository.saveAndFlush(bus);
    }

    @Override
    public List<Bus> getAll() {
        return busRepository.findAll();
    }
}
