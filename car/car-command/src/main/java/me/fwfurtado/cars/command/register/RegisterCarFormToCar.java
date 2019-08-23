package me.fwfurtado.cars.command.register;

import me.fwfurtado.cars.command.domain.Car;
import me.fwfurtado.cars.command.domain.CarStatus;
import me.fwfurtado.cars.command.register.RegisterCarController.RegisterCarForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class RegisterCarFormToCar implements Converter<RegisterCarForm, Car> {

    @Override
    public Car convert(RegisterCarController.RegisterCarForm form) {
        return new Car( form.getBrand(),
                        CarStatus.WAITING_FOR_APPROVAL,
                        form.getModel(),
                        form.getModelYear(),
                        form.getReleaseYear(),
                        form.getLicensePlate(),
                        form.getLatitude(),
                        form.getLongitude());
    }
}
