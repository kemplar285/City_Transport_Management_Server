package ee.cybernetica.repository;

import ee.cybernetica.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
    Bus findBusByLicenceNumber(String licenceNumber);
}
