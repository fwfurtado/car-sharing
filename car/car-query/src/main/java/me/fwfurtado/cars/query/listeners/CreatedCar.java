package me.fwfurtado.cars.query.listeners;

import java.time.Year;
import java.util.List;
import java.util.UUID;
import me.fwfurtado.cars.query.domain.Brand;
import me.fwfurtado.cars.query.domain.CarStatus;

public class CreatedCar {

    private UUID id;
    private String model;
    private Brand brand;
    private Year releaseYear;
    private Year modelYear;
    private String licensePlate;
    private UUID ownerId;
    private String ownerName;
    private String ownerBio;
    private List<Double> location;
    private CarStatus status;

    /**
     * @deprecated used by frameworks
     */
    @Deprecated
    private CreatedCar() {
    }

    public CreatedCar(UUID id, String model, Brand brand, Year releaseYear, Year modelYear, String licensePlate, CarStatus status, UUID ownerId, String ownerName, String ownerBio, List<Double> location) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.releaseYear = releaseYear;
        this.modelYear = modelYear;
        this.licensePlate = licensePlate;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerBio = ownerBio;
        this.location = location;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Brand getBrand() {
        return brand;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public Year getModelYear() {
        return modelYear;
    }

    public String getLicensePlate() {
        return licensePlate;
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

    public List<Double> getLocation() {
        return location;
    }

    public CarStatus getStatus() {
        return status;
    }
}
