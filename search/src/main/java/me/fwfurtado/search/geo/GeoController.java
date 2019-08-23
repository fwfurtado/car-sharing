package me.fwfurtado.search.geo;

import java.util.List;
import me.fwfurtado.search.domain.CarMatch;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoController {

    private final double distanceInKM;
    private final GeoRepository repository;

    GeoController(@Value("${car-sharing.max-distance}") double distanceInKM, GeoRepository repository) {
        this.distanceInKM = distanceInKM;
        this.repository = repository;
    }

    @GetMapping("near")
    List<CarMatch> searchBy(Double latitude, Double longitude) {
        Point point = new Point(latitude, longitude);

        Distance distance = new Distance(distanceInKM, Metrics.KILOMETERS);

        return repository.findAllByLocationNear(point, distance);
    }
}
