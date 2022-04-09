package ee.cybernetica.service;

import ee.cybernetica.model.Bus;

import java.util.List;

public interface CityTransportService<T, I> {
    T add(T item);
    void delete(I id);
    T getById(I id);
    T edit(T item);
    List<T> getAll();
}
