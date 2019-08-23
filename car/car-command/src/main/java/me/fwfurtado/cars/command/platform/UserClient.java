package me.fwfurtado.cars.command.platform;

import java.util.Optional;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "${car-sharing.services.user}", decode404 = true, fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Optional<UserResponse> findUserById(@PathVariable("id")  UUID id);
}
