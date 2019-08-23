package me.fwfurtado.cars.command.register;

import java.util.UUID;
import me.fwfurtado.cars.command.domain.Car;
import me.fwfurtado.cars.command.domain.Owner;
import me.fwfurtado.cars.command.platform.EventPublisher;
import me.fwfurtado.cars.command.platform.UserService;
import me.fwfurtado.cars.command.register.RegisterCarController.RegisterCarForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class RegisterCarService {

    private final RegisterCarRepository repository;
    private final UserService userService;
    private final Converter<RegisterCarForm, Car> formCarConverter;
    private final EventPublisher publisher;

    RegisterCarService(RegisterCarRepository repository, UserService userService, Converter<RegisterCarForm, Car> formCarConverter, EventPublisher publisher) {
        this.repository = repository;
        this.userService = userService;
        this.formCarConverter = formCarConverter;
        this.publisher = publisher;
    }

    UUID registerBy(RegisterCarForm form) {
        UUID ownerId = form.getOwnerId();

        Owner owner = userService.findOwnerById(ownerId);

        Car car = formCarConverter.convert(form);

        car.updateOwner(owner);

        repository.save(car);

        publisher.fireRegistrationOf(car);

        return car.getId();
    }
}
