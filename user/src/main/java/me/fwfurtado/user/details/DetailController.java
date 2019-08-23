package me.fwfurtado.user.details;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.UUID;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DetailController {

    private final DetailService service;

    DetailController(DetailService service) {
        this.service = service;
    }

    @GetMapping("/users/{id}")
    ResponseEntity<?> show(@PathVariable UUID id) {
        return service.findUserById(id)
            .map(ok()::body)
            .orElseGet(notFound()::build);
    }

}
