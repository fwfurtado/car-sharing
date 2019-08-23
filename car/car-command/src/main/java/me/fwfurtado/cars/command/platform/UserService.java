package me.fwfurtado.cars.command.platform;

import java.text.MessageFormat;
import java.util.UUID;
import me.fwfurtado.cars.command.domain.Owner;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class UserService {
    private final UserClient client;
    private final Converter<UserResponse, Owner> converter;

    public UserService(UserClient client, Converter<UserResponse, Owner> converter) {
        this.client = client;
        this.converter = converter;
    }


    public Owner findOwnerById(UUID ownerId) {
        return  client
                    .findUserById(ownerId)
                    .map(converter::convert)
                        .orElseThrow(() -> new OwnerNotFoundException(MessageFormat.format("Cannot find any user with id '{}'", ownerId)));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private class OwnerNotFoundException extends IllegalArgumentException {

        OwnerNotFoundException(String message) {
            super(message);
        }
    }
}
