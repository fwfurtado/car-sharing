package me.fwfurtado.cars.command.register;

import static org.springframework.http.ResponseEntity.created;

import java.net.URI;
import java.time.Year;
import java.util.UUID;
import javax.validation.Valid;
import me.fwfurtado.cars.command.domain.Brand;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cars")
class RegisterCarController {

    private final RegisterCarService service;

    RegisterCarController(RegisterCarService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> registerBy(@RequestBody @Valid RegisterCarForm form, UriComponentsBuilder uriBuilder) {

        UUID id = service.registerBy(form);

        URI uri = uriBuilder.path("cars/{id}").build(id);

        return created(uri).build();
    }

    static class RegisterCarForm {

        private UUID ownerId;
        private Brand brand;
        private String model;
        private Year modelYear;
        private Year releaseYear;
        private String licensePlate;
        private double latitude;
        private double longitude;

        RegisterCarForm() {
        }

        public RegisterCarForm(UUID ownerId, Brand brand, String model, Year modelYear, Year releaseYear, String licensePlate, double latitude, double longitude) {
            this.ownerId = ownerId;
            this.brand = brand;
            this.model = model;
            this.modelYear = modelYear;
            this.releaseYear = releaseYear;
            this.licensePlate = licensePlate;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public UUID getOwnerId() {
            return ownerId;
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

        public String getLicensePlate() {
            return licensePlate;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }
}
