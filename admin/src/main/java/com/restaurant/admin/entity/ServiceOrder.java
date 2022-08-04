package com.restaurant.admin.entity;

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
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private String drinksIncludes;
    private String price;
    private long cant;
    private long tableNumber;
    private long ordered;
    private long prepare;
    private long prepared;
    private long close;
    private long cancel;
    private String image;
    private long discount;
    private String paymentMethod;
    private String time;

}
