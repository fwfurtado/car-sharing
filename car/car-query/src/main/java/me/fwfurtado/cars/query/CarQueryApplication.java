package me.fwfurtado.cars.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CarQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarQueryApplication.class, args);
    }
}
