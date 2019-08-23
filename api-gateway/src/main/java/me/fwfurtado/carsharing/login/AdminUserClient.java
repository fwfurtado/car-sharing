package me.fwfurtado.carsharing.login;

import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${car-sharing.services.user}", decode404 = false)
interface AdminUserClient {

    @GetMapping(value = "/admin/users/{email}")
    Optional<User> getUserByEmail(String email, @RequestHeader  HttpHeaders headers);
}
