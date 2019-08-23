package me.fwfurtado.search.geo;

import java.util.List;
import java.util.UUID;
import me.fwfurtado.search.domain.CarMatch;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.Repository;

interface GeoRepository extends Repository<CarMatch, UUID> {

    List<CarMatch> findAllByLocationNear(Point point, Distance distance);
}
