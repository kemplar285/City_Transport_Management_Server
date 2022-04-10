package ee.cybernetica.service.impl;

import ee.cybernetica.exception.BusNotFound;
import ee.cybernetica.model.Bus;
import ee.cybernetica.repository.BusRepository;
import ee.cybernetica.service.CityTransportService;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
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
    public void delete(Integer id) throws BusNotFound {
        this.getById(id);
        busRepository.deleteById(id);
    }

    @Override
    public Bus getById(Integer id) throws BusNotFound {
        return busRepository.findById(id).orElseThrow(() -> new BusNotFound("Bus not found"));
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
