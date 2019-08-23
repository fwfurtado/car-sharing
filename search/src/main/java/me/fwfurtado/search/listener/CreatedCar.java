package me.fwfurtado.search.listener;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
class CreatedCar {
    private UUID id;
    private String brand;
    private String model;
    private String ownerName;
    private List<Double> location;
    private String status;

    public boolean isActive() {
        return "ACTIVE".equals(status);
    }
}
