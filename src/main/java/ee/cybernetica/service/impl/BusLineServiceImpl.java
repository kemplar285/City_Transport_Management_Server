package ee.cybernetica.service.impl;

import ee.cybernetica.exception.BusLineNotFoundException;
import ee.cybernetica.model.BusLine;
import ee.cybernetica.repository.BusLineRepository;
import ee.cybernetica.service.CityTransportService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusLineServiceImpl implements CityTransportService<BusLine, Integer> {
    private final BusLineRepository busLineRepository;

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
    public BusLine getById(Integer id) throws BusLineNotFoundException {
        return busLineRepository.findById(id).orElseThrow(() -> new BusLineNotFoundException("Bus line not found"));
    }

    @Override
    public BusLine edit(BusLine item) {
        return busLineRepository.saveAndFlush(item);
    }

    @Override
    public List<BusLine> getAll() {
        return busLineRepository.findAll();
    }

    /**
     * Determines which parameters are present and calls corresponding repository method.
     * @param limit max records
     * @param name bus line name
     * @param busStopId busStopId in busStopIds
     * @return
     */
    public List<BusLine> getAllWithOptionalParams(Integer limit, Optional<String> name, Optional<Integer> busStopId) {
        Pageable pageRequest = PageRequest.of(0, limit);
        if (name.isPresent() && busStopId.isPresent()) {
            List<BusLine> busLines = busLineRepository.findWithNameAndLimit(name.get(), pageRequest)
                    .stream()
                    .filter(busLine -> busLine.getBusStopIds().contains(busStopId.get()))
                    .collect(Collectors.toList());
            return busLines;
        } else if (busStopId.isPresent()) {
            List<BusLine> busLines = busLineRepository.findWithPageable(pageRequest)
                    .stream()
                    .filter(busLine -> busLine.getBusStopIds().contains(busStopId.get()))
                    .collect(Collectors.toList());
            return busLines;
        } else if (name.isPresent()) {
            return busLineRepository.findWithNameAndLimit(name.get(), pageRequest);
        } else {
            return busLineRepository.findWithPageable(pageRequest);
        }
    }

    public List<BusLine> getAllWithBusStopIdInBusStopIds(Integer busStopId){
        return busLineRepository.findAll()
                .stream()
                .filter(busLine -> busLine.getBusStopIds().contains(busStopId))
                .collect(Collectors.toList());
    }
}
