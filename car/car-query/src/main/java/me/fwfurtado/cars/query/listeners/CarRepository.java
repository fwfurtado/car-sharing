package me.fwfurtado.cars.query.listeners;

import java.util.UUID;
import me.fwfurtado.cars.query.domain.Car;
import org.springframework.data.repository.Repository;

interface CarRepository extends Repository<Car, UUID> {
    void save(Car car);
}
