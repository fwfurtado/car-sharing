package me.fwfurtado.cars.command.platform;

import java.util.stream.Stream;
import me.fwfurtado.cars.command.CarCommandApplication.MyBind;
import me.fwfurtado.cars.command.domain.Car;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.core.convert.converter.Converter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    private final MessageChannel channel;
    private final Converter<Car, CreatedCar> registrationConverter;

    public EventPublisher(Converter<Car, CreatedCar> registrationConverter, @Output(MyBind.CARS) MessageChannel channel) {
        this.registrationConverter = registrationConverter;
        this.channel = channel;
    }

    public void fireRegistrationOf(Car car) {
        CreatedCar event = registrationConverter.convert(car);

        Message<CreatedCar> build = MessageBuilder.withPayload(event).build();

        channel.send(build);
    }
}
