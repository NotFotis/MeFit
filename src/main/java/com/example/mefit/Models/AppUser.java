package com.example.mefit.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class AppUser {
    @Id
    private String uid;

    private String username;
    private String firstname;
    private String lastname;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="profile_id")
    private Profile profile;

}
