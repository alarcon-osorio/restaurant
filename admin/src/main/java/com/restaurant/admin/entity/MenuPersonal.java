package com.restaurant.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu_personal_view", schema="restaurant")
public class MenuPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username")
    private String username;
    @Column(name="id_menu_type")
    private long id_menu_type;
    @Column(name="name_dish")
    private String mp_name_dish;
    @Column(name="options")
    private String mp_options;
    @Column(name="principles")
    private String mp_principles;
    @Column(name="proteins")
    private String mp_proteins;
    @Column(name="entries")
    private String mp_entries;
    @Column(name="vegetables")
    private String mp_vegetables;
    @Column(name="salad")
    private String mp_salad;
    @Column(name="drinks")
    private String mp_drinks;
    @Column(name="observations")
    private String mp_observations;

}
