package me.fwfurtado.user.details;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.Optional;
import java.util.UUID;
import me.fwfurtado.user.UserApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringRunner.class)
public abstract class DetailBase {

    @Before
    public void setup() {
        DetailService service = mock(DetailService.class);

        RestAssuredMockMvc.standaloneSetup(new DetailController(service));

        UUID validId = UUID.fromString("13e09757-95b4-4d7c-88cd-5678796bbdfd");
        UUID invalidId = UUID.fromString("13330ed4-e197-4ee7-bda4-da12067f58fd");

        UserResponse response = new UserResponse() {

            @Override
            public UUID getId() {
                return validId;
            }

            @Override
            public String getName() {
                return "Fernando";
            }

            @Override
            public String getBio() {
                return "Some bio here!";
            }

            @Override
            public String getEmail() {
                return "fernando@email.com";
            }
        };

        when(service.findUserById(validId)).thenReturn(Optional.of(response));
        when(service.findUserById(invalidId)).thenReturn(Optional.empty());
    }
}
