package com.example.mefit.models.dtos.profile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDTO {
    private int profile_id;
    private int age;
    private int weight;
    private int height;
    private int goal;
}
