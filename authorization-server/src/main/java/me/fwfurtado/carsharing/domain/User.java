package me.fwfurtado.carsharing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.omg.PortableInterceptor.ACTIVE;
import org.omg.PortableInterceptor.INACTIVE;

@Entity
@Table(name = "users")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "binary(16)")
    private UUID id;
    private String username;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role")
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"))
    List<String> roles = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public enum UserStatus {
        WAITING_FOR_APPROVAL,
        ACTIVE,
        INACTIVE
    }

}
