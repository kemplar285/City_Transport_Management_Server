package ee.cybernetica.repository;

import ee.cybernetica.model.BusLine;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BusLineRepository extends JpaRepository<BusLine, Integer> {
    @Query(value="select b from BusLine b")
    public List<BusLine> findWithPageable(Pageable pageable);
}
