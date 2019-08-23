package me.fwfurtado.carsharing.login;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
class UserToResourceOwner implements Converter<User, ResourceOwner> {

    @Override
    public ResourceOwner convert(User user) {

        Set<SimpleGrantedAuthority> roles = user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(toSet());

        return new ResourceOwner(user.getEmail(), user.getPassword(), user.getStatus(), roles);
    }
}
