package me.fwfurtado.carsharing.login;

import static java.util.Collections.singletonList;

import java.text.MessageFormat;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
class LoginService implements UserDetailsService {

    private static final MessageFormat exceptionFormatter = new MessageFormat("Cannot find user with e-mail '{}'");

    private final AdminUserClient client;
    private final Converter<User, ResourceOwner> converter;

    LoginService(AdminUserClient client, Converter<User, ResourceOwner> converter) {
        this.client = client;
        this.converter = converter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("123");
        headers.setAccept(singletonList(MediaType.APPLICATION_JSON));

        return client.getUserByEmail(username, headers).map(converter::convert).orElseThrow(() -> new UsernameNotFoundException(exceptionFormatter.format(username)));
    }
}
