package me.fwfurtado.cars.command.platform;

import me.fwfurtado.cars.command.domain.Owner;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class UserResponseToOwnerConverter implements Converter<UserResponse, Owner> {

    @Override
    public Owner convert(UserResponse response) {
        return new Owner(response.getId(), response.getName(), response.getBio());
    }
}
