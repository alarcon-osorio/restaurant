package com.restaurant.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "warehouse")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String numberProduct;
    private String name;
    private String description;
    private String type;
    private String status;
    private String measureUnit;
    private String priceUnit;
    private String datePriceUnit;
    private String salePrice;
    private String dateSalePrice;
    private String cantDisp;
    private String cantOrder;
    private String cantMinInv;
    private String date;
    private String totalInventory;

}
