package me.fwfurtado.search.domain;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@Document(collection = "cars")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CarMatch {

    @Id
    private UUID id;
    private String model;
    private String brand;
    private String ownerName;
    private Point location;
    private boolean active;
}
