package ee.cybernetica.citytransport;

import ee.cybernetica.model.Bus;
import ee.cybernetica.model.BusLine;
import ee.cybernetica.model.BusStop;
import ee.cybernetica.repository.BusLineRepository;
import ee.cybernetica.repository.BusRepository;
import ee.cybernetica.repository.BusStopRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.naming.Name;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EntityScan("ee.cybernetica.*")
@EnableJpaRepositories("ee.cybernetica.*")
@ComponentScan(basePackages = {"ee.cybernetica.*"})
public class CityTransportApplication {
    private final BusRepository busRepository;
    private final BusLineRepository busLineRepository;
    private final BusStopRepository busStopRepository;

    public CityTransportApplication(BusRepository busRepository
            , BusLineRepository busLineRepository, BusStopRepository busStopRepository) {
        this.busRepository = busRepository;
        this.busLineRepository = busLineRepository;
        this.busStopRepository = busStopRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CityTransportApplication.class, args);
    }

    @Bean
    InitializingBean testData() {
        return () -> {
            // Test bus stop
            BusStop busStop = new BusStop();
            busStop.setLatitude("a");
            busStop.setLongitude("b");
            busStop.setName("testStop");

            // Test bus line
            BusLine busLine = new BusLine();
            busLine.setName("testLine");
            busLine.addBusStop(busStop, LocalTime.of(12, 0));


            // Test bus
            Bus bus = new Bus();
            bus.setLicenceNumber("testBus");
            bus.setBusLine(busLine);

            // Save
            busStopRepository.save(busStop);
            busLineRepository.save(busLine);
            busRepository.save(bus);
        };
    }


}
