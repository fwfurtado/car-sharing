package me.fwfurtado.cars.command.contracts.base.registration;

import java.time.Year;
import java.util.UUID;
import javax.inject.Inject;
import me.fwfurtado.cars.command.CarCommandApplication;
import me.fwfurtado.cars.command.domain.Car;
import me.fwfurtado.cars.command.domain.CarStatus;
import me.fwfurtado.cars.command.domain.Owner;
import me.fwfurtado.cars.command.platform.EventPublisher;
import me.fwfurtado.cars.command.domain.Brand;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest(classes = CarCommandApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMessageVerifier
@ActiveProfiles("test")
public abstract class RegistrationBase {

    @Autowired
    private EventPublisher publisher;

    public void registrationCar() {

        Car camaro = new Car(Brand.CHEVROLET, CarStatus.WAITING_FOR_APPROVAL, "Camaro", Year.of(2017), Year.of(2017),
            "ABC-1234", -23.426478, -46.123456);

        ReflectionTestUtils
            .setField(camaro, "id", UUID.fromString("ddbb7efa-7276-4112-8fb1-d9b1d07ab66b"));

        camaro.updateOwner(new Owner(UUID.fromString("13e09757-95b4-4d7c-88cd-5678796bbdfd"), "Fernando", "Some bio here!"));

        publisher.fireRegistrationOf(camaro);

    }
}
