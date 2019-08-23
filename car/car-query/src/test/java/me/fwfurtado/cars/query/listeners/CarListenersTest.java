package me.fwfurtado.cars.query.listeners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

import java.time.Year;
import java.util.UUID;
import me.fwfurtado.cars.query.domain.Brand;
import me.fwfurtado.cars.query.domain.Car;
import me.fwfurtado.cars.query.domain.CarStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@AutoConfigureStubRunner(stubsMode = StubsMode.REMOTE,
    consumerName = "car-query-consumer",
    repositoryRoot = "git://git@github.com:fwfurtado/car-sharing-contracts.git",
    ids = "me.fwfurtado.carsharing:car-command:+:stubs")
public class CarListenersTest {

    @Autowired
    private StubTrigger trigger;

    @MockBean
    private CarRepository repository;

    @Captor
    private ArgumentCaptor<Car> carArgumentCaptor;

    @Test
    public void shouldReceiveANewCar() {
        trigger.trigger("registerCar");

        then(repository).should().save(carArgumentCaptor.capture());

        Car car = carArgumentCaptor.getValue();

        assertThat(car)
            .hasFieldOrPropertyWithValue("id", UUID.fromString("ddbb7efa-7276-4112-8fb1-d9b1d07ab66b"))
            .hasFieldOrPropertyWithValue("brand", Brand.CHEVROLET)
            .hasFieldOrPropertyWithValue("model", "Camaro")
            .hasFieldOrPropertyWithValue("modelYear", Year.of(2017))
            .hasFieldOrPropertyWithValue("releaseYear", Year.of(2017))
            .hasFieldOrPropertyWithValue("licensePlate", "ABC-1234")
            .hasFieldOrPropertyWithValue("ownerId", UUID.fromString("13e09757-95b4-4d7c-88cd-5678796bbdfd"))
            .hasFieldOrPropertyWithValue("ownerName", "Fernando")
            .hasFieldOrPropertyWithValue("ownerBio", "Some bio here!")
            .hasFieldOrPropertyWithValue("status", CarStatus.WAITING_FOR_APPROVAL)
            ;

    }
}