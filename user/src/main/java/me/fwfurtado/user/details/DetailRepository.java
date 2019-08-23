package me.fwfurtado.user.details;

import java.util.Optional;
import java.util.UUID;
import me.fwfurtado.user.domain.User;
import org.springframework.data.repository.Repository;

interface DetailRepository extends Repository<User, UUID> {
    Optional<UserResponse> getUserById(UUID id);
}
