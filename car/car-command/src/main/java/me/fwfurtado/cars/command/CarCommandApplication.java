package me.fwfurtado.cars.command;

import me.fwfurtado.cars.command.CarCommandApplication.MyBind;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.client.RestTemplate;

@EnableBinding(MyBind.class)
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@EnableOAuth2Sso
@SpringBootApplication
public class CarCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarCommandApplication.class, args);
    }


    public interface MyBind {
        String CARS = "cars";

        @Output(MyBind.CARS)
        MessageChannel cars();
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
