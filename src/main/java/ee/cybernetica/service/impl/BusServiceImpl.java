package ee.cybernetica.service.impl;

import ee.cybernetica.exception.BusNotFoundException;
import ee.cybernetica.model.Bus;
import ee.cybernetica.model.BusLine;
import ee.cybernetica.repository.BusRepository;
import ee.cybernetica.service.CityTransportService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public void delete(Integer id) throws BusNotFoundException {
        this.getById(id);
        busRepository.deleteById(id);
    }

    @Override
    public Bus getById(Integer id) throws BusNotFoundException {
        return busRepository.findById(id).orElseThrow(() -> new BusNotFoundException("Bus not found"));
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
