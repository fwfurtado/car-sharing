package me.fwfurtado.cars.query.listeners;

import me.fwfurtado.cars.query.domain.Car;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class CreatedCarToCar implements Converter<CreatedCar, Car> {

    @Override
    public Car convert(CreatedCar event) {
        return new Car(event.getId(), event.getOwnerId(), event.getOwnerName(), event.getOwnerBio(),
            event.getBrand(), event.getStatus(), event.getModel(),event.getModelYear(), event.getReleaseYear(), event.getLicensePlate()) ;
    }
}
