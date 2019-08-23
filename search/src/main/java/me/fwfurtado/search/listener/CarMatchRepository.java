package me.fwfurtado.search.listener;

import java.util.UUID;
import me.fwfurtado.search.domain.CarMatch;
import org.springframework.data.repository.Repository;

interface CarMatchRepository extends Repository<CarMatch, UUID> {

    void save(CarMatch car);
}
