package me.fwfurtado.cars.command.platform;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    @Override
    public Optional<UserResponse> findUserById(UUID id) {
        return Optional.empty();
    }
}
