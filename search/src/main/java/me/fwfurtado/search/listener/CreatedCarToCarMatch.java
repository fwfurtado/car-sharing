package me.fwfurtado.search.listener;

import me.fwfurtado.search.domain.CarMatch;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

@Component
class CreatedCarToCarMatch implements Converter<CreatedCar, CarMatch> {

    @Override
    public CarMatch convert(CreatedCar car) {
        Double latitude =  car.getLocation().get(0);
        Double longitude = car.getLocation().get(1);

        Point location = new Point(latitude, longitude);

        return new CarMatch(car.getId(), car.getModel(), car.getBrand(), car.getOwnerName(), location, car.isActive());
    }
}
