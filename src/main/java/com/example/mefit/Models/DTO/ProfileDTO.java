package com.example.mefit.Models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDTO {
    private int id;
    private int age;
    private int weight;
    private int height;
    private String medical_condition;
    private String disabilities;
    private int user;
    private int goal;
}
