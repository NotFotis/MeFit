package com.example.mefit.Models.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class userDTO {
    private int id;
    private String password;
    private String firstName;
    private String lastName;

    public boolean contributor;

    public boolean admin;
    private int profile;
}
