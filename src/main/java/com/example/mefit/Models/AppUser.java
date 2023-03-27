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
    private String bio;
    private boolean complete;

    @OneToOne(mappedBy = "user")
    private Profile profile;
}
