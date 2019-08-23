package me.fwfurtado.cars.command.register;

import java.util.UUID;
import me.fwfurtado.cars.command.domain.Car;
import org.springframework.data.repository.Repository;

interface RegisterCarRepository extends Repository<Car, UUID> {
    void save(Car car);
}
