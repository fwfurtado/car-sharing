package me.fwfurtado.carsharing.login;

import static java.util.stream.Collectors.toList;
import static me.fwfurtado.carsharing.domain.User.UserStatus.*;

import java.util.Collection;
import java.util.List;
import me.fwfurtado.carsharing.domain.User.UserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ResourceOwner implements UserDetails {

    private final String username;
    private final String password;
    private final UserStatus status;
    private final List<? extends GrantedAuthority> roles;

    ResourceOwner(String username, String password, UserStatus status, List<? extends GrantedAuthority> roles) {

        this.username = username;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status != INACTIVE;
    }
}
