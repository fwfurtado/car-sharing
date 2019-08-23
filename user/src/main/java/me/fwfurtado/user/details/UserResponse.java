package me.fwfurtado.user.details;

import java.util.UUID;

public interface UserResponse {
    UUID getId();
    String getName();
    String getBio();
    String getEmail();
}
