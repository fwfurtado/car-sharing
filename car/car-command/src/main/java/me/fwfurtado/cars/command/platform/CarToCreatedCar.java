package me.fwfurtado.cars.command.platform;

import java.util.Arrays;
import java.util.List;
import me.fwfurtado.cars.command.domain.Car;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class CarToCreatedCar implements Converter<Car, CreatedCar> {

    @Override
    public CreatedCar convert(Car car) {
        List<Double> location = Arrays.asList(car.getLatitude(), car.getLongitude());

        return new CreatedCar(car.getId(), car.getModel(), car.getBrand(), car.getReleaseYear(), car.getModelYear(),
            car.getLicensePlate(), car.getStatus(), car.getOwnerId(), car.getOwnerName(), car.getOwnerBio(), location);
    }
}
