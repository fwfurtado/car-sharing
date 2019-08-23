package me.fwfurtado.cars.command.domain;

import java.time.Year;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "binary(16)")
    private UUID id;

    @Embedded
    private Owner owner;

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
    private double latitude;
    private double longitude;

    /**
     * @deprecated used by frameworks
     */
    @Deprecated
    private Car() {
    }

    public Car(Brand brand, CarStatus status, String model, Year modelYear, Year releaseYear, String licensePlate, double latitude, double longitude) {
        this.brand = brand;
        this.status = status;
        this.model = model;
        this.modelYear = modelYear;
        this.releaseYear = releaseYear;
        this.licensePlate = licensePlate;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public UUID getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public UUID getOwnerId() {
        return owner.getId();
    }

    public String getOwnerName() {
        return owner.getName();
    }

    public String getOwnerBio() {
        return owner.getBio();
    }

    public Brand getBrand() {
        return brand;
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

    public CarStatus getStatus() {
        return status;
    }

    public void updateOwner(Owner owner) {
        this.owner = owner;
    }
}
