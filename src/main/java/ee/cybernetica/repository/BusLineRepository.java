package ee.cybernetica.repository;

import ee.cybernetica.model.BusLine;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BusLineRepository extends JpaRepository<BusLine, Integer> {
    @Query(value="select b from BusLine b")
    public List<BusLine> findWithPageable(Pageable pageable);

    @Query(value="select b from BusLine b where b.name=:name")
    List<BusLine> findWithNameAndLimit(@Param("name") String name, Pageable pageRequest);
}
