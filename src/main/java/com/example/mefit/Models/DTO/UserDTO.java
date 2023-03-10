package com.example.mefit.Models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Boolean isContributor;
    private Boolean isAdmin;
}
