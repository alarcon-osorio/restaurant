package com.restaurant.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuPersonalDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private long id_menu_type;
    private String name_dish;
    private String options;
    private String principles;
    private String proteins;
    private String entries;
    private String vegetables;
    private String salad;
    private String drinks;
    private String observations;
    private String time;

}
