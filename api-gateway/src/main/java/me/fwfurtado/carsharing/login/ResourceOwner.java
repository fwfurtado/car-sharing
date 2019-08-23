package me.fwfurtado.carsharing.login;

import static me.fwfurtado.carsharing.login.User.UserStatus.INACTIVE;

import java.util.Collection;
import me.fwfurtado.carsharing.login.User.UserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ResourceOwner implements UserDetails {

    private String username;
    private String password;
    private UserStatus status;
    private Collection<? extends GrantedAuthority> roles;

    public ResourceOwner(String username, String password, UserStatus status, Collection<? extends GrantedAuthority> roles) {
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
