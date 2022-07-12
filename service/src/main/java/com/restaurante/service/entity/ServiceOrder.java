package com.restaurante.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "service_order")
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idMenu;
    private long idMenuType;
    private String name;
    private String description;
    private String observations;
    private String accompaniment;
    private String drinksIncludes;
    private String price;
    private String tableNumber;
    private String image;
    private String time;

}
