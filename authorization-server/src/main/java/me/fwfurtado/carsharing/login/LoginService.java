package me.fwfurtado.carsharing.login;

import java.text.MessageFormat;
import me.fwfurtado.carsharing.domain.User;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
class LoginService implements UserDetailsService {

    private static MessageFormat notFoundFormatter = new MessageFormat("Cannot find user with this username '{}'");

    private final LoginRepository repository;
    private final Converter<User, ResourceOwner> converter;

    public LoginService(LoginRepository repository, Converter<User, ResourceOwner> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
                .findByUsername(username)
                    .map(converter::convert)
                        .orElseThrow(() -> new UsernameNotFoundException(notFoundFormatter.format(username)));
    }
}
