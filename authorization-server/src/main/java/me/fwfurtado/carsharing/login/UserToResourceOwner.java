package me.fwfurtado.carsharing.login;

import java.util.List;
import me.fwfurtado.carsharing.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component
class UserToResourceOwner implements Converter<User, ResourceOwner> {

    @Override
    public ResourceOwner convert(User user) {
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(user.getRoles().toArray(new String[]{}));

        return new ResourceOwner(user.getUsername(), user.getPassword(), user.getStatus(), authorities);
    }
}
