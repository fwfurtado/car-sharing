package me.fwfurtado.search.listener;

import me.fwfurtado.search.domain.CarMatch;
import me.fwfurtado.search.listener.CarCreationListener.CarChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.core.convert.converter.Converter;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(CarChannel.class)
class CarCreationListener {
    private final Converter<CreatedCar, CarMatch> converter;
    private final CarMatchRepository repository;

    CarCreationListener(Converter<CreatedCar, CarMatch> converter, CarMatchRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @StreamListener(CarChannel.CARS)
    void receive(CreatedCar car) {
        CarMatch carMatch = converter.convert(car);

        repository.save(carMatch);
    }

    interface CarChannel {
        String CARS = "cars";

        @Input(CARS)
        MessageChannel created();
    }
}
