package me.fwfurtado.cars.query.listeners;

import me.fwfurtado.cars.query.domain.Car;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class CarListeners {

    private final CarRepository repository;
    private final Converter<CreatedCar, Car> converter;

    public CarListeners(CarRepository repository, Converter<CreatedCar, Car> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @StreamListener(Sink.INPUT)
    void handle(CreatedCar event) {
        Car car = converter.convert(event);

        repository.save(car);
    }
}
