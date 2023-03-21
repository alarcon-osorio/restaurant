package com.restaurant.client.security.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients", schema="restaurant")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String role;
    private String password;
    private boolean enabled;

}