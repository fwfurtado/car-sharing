package me.fwfurtado.user.details;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
class DetailService {

    private final DetailRepository repository;

    DetailService(DetailRepository repository) {
        this.repository = repository;
    }

    Optional<UserResponse> findUserById(UUID id) {
        return repository.getUserById(id);
    }
}
