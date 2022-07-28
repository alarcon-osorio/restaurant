package com.restaurant.cash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloseDay {

    @Id
    private long id;
    private String name;
    private long cant;
    private long tableNumber;
    private String time;
    private String totalItem;
    private long discount;
    private String paymentMethod;
}
