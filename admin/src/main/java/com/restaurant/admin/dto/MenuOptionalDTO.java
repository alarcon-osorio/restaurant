package com.restaurant.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu_optional")
public class MenuOptionalDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String menu;
    private String menuType;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;

}
