package me.fwfurtado.cars.query.domain;

import java.time.Year;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(columnDefinition = "binary(16)")
    private UUID id;

    @Column(columnDefinition = "binary(16)")
    private UUID ownerId;

    private String ownerName;

    private String ownerBio;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    private String model;

    @Column(columnDefinition = "year")
    private Year modelYear;

    @Column(columnDefinition = "year")
    private Year releaseYear;

    private String licensePlate;

    /**
     * @deprecated used by frameworks
     */
    @Deprecated
    private Car() {
    }

    public Car(UUID id, UUID ownerId, String ownerName, String ownerBio, Brand brand, CarStatus status, String model, Year modelYear, Year releaseYear, String licensePlate) {
        this.id = id;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerBio = ownerBio;
        this.brand = brand;
        this.status = status;
        this.model = model;
        this.modelYear = modelYear;
        this.releaseYear = releaseYear;
        this.licensePlate = licensePlate;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerBio() {
        return ownerBio;
    }

    public Brand getBrand() {
        return brand;
    }

    public CarStatus getStatus() {
        return status;
    }

    public String getModel() {
        return model;
    }

    public Year getModelYear() {
        return modelYear;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
