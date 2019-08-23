package me.fwfurtado.cars.command.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Owner {

    @Column(name = "owner_id",columnDefinition = "binary(16)")
    private UUID id;

    @Column(name = "owner_name")
    private String name;

    @Column(name = "owner_bio")
    private String bio;

    @Deprecated
    private Owner() {
    }

    public Owner(UUID id, String name, String bio) {
        this.id = id;
        this.name = name;
        this.bio = bio;
    }

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
