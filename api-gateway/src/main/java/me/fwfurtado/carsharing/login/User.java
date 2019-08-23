package me.fwfurtado.carsharing.login;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String password;
    private UserStatus status;

    private Set<String> roles = new HashSet<>();

    public enum UserStatus {
        WAITING_FOR_APPROVAL, ACTIVE, INACTIVE
    }

    /**
     * @deprecated
     */
    @Deprecated
    User() {}

    public User(UUID id, String email, String password, UserStatus status, Set<String> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
