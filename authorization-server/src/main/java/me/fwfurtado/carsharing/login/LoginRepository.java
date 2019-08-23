package me.fwfurtado.carsharing.login;

import java.util.Optional;
import java.util.UUID;
import me.fwfurtado.carsharing.domain.User;
import org.springframework.data.repository.Repository;

interface LoginRepository extends Repository<User, UUID> {

    Optional<User> findByUsername(String username);
}
