package com.example.mefit.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", schema = "public")
public class User {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    public Integer id;

    @Column
    @Size(min = 1, max = 100)
    public String password;

    @Column
    public String firstName;

    @Column
    public String lastName;

    @Column
    public boolean contributor;

    @Column
    public boolean admin;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "profile_user",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "profile_id") }
    )
    private Profile profile;
}
