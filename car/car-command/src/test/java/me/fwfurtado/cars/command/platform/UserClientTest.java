package me.fwfurtado.cars.command.platform;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@EnableStubRunnerServer
@AutoConfigureStubRunner(
    stubsMode = StubsMode.REMOTE,
    consumerName = "car-command-consumer",
    repositoryRoot = "git://git@github.com:fwfurtado/car-sharing-contracts.git",
    ids = "me.fwfurtado:user:+:stubs:8030"
)
public class UserClientTest {

    @Autowired
    private UserClient client;

    static {
        System.setProperty("eureka.client.enabled", "false");
        System.setProperty("spring.cloud.config.failFast", "false");
    }

    @Test
    public void shouldReturnAUserResponseWhenRequestWithAValidId() {
        UUID id = UUID.fromString("13e09757-95b4-4d7c-88cd-5678796bbdfd");

        Optional<UserResponse> response = client.findUserById(id);

        assertThat(response).isPresent()
            .get()
            .hasFieldOrPropertyWithValue("id", id)
            .hasFieldOrPropertyWithValue("name", "Fernando")
            .hasFieldOrPropertyWithValue("bio", "Some bio here!")
        ;
    }

    @Test
    public void shouldReturn404WhenRequestAUserWithAnInvalidId() {
        UUID id = UUID.fromString("13330ed4-e197-4ee7-bda4-da12067f58fd");

        Optional<UserResponse> response = client.findUserById(id);

        assertThat(response).isEmpty();
    }

}