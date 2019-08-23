package me.fwfurtado.cars.command.platform;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
class UserResponse {

    private UUID id;
    private String name;
    private String bio;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }
}
