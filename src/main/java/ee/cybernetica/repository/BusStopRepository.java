package ee.cybernetica.repository;
import ee.cybernetica.model.BusStop;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusStopRepository extends JpaRepository<BusStop, Integer> {
    @Query(value="select b from BusStop b where b.name = :name")
    List<BusStop> findAllByNameWithLimit(@Param("name") String name, Pageable pageRequest);

    @Query(value="select b from BusStop b")
    List<BusStop> findAllWithLimit(Pageable pageRequest);
}
