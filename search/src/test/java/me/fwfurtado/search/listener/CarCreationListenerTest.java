package me.fwfurtado.search.listener;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.then;

import java.time.Year;
import java.util.UUID;
import me.fwfurtado.search.SearchApplication;
import me.fwfurtado.search.domain.CarMatch;
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
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@AutoConfigureStubRunner(stubsMode = StubsMode.REMOTE,
    consumerName = "search-consumer",
    repositoryRoot = "git://git@github.com:fwfurtado/car-sharing-contracts.git",
    ids = "me.fwfurtado.carsharing:car-command:+:stubs")
public class CarCreationListenerTest {

    @Autowired
    private StubTrigger trigger;

    @MockBean
    private CarMatchRepository repository;

    @Captor
    private ArgumentCaptor<CarMatch> carMatchCaptor;

    @Test
    public void shouldCreateANewCarMatchWhenReceiveACreatedCarEvent() {
        trigger.trigger("registerCar");

        then(repository).should().save(carMatchCaptor.capture());

        CarMatch carMatch = carMatchCaptor.getValue();

        assertThat(carMatch)
            .hasFieldOrPropertyWithValue("id", UUID.fromString("ddbb7efa-7276-4112-8fb1-d9b1d07ab66b"))
            .hasFieldOrPropertyWithValue("brand", "CHEVROLET")
            .hasFieldOrPropertyWithValue("model", "Camaro")
            .hasFieldOrPropertyWithValue("ownerName", "Fernando")
            .hasFieldOrPropertyWithValue("active", false)
            .hasFieldOrPropertyWithValue("location", new Point(-23.426478, -46.123456))

        ;
    }
}