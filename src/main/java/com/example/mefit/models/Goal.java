package com.example.mefit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goal_id;
    @Column(length = 30, nullable = false)
    private String goal_name;
    @Column
    private LocalDate start_date;
    @Column
    private LocalDate end_date;
    @Column()
    private int total_programs;
    @Column()
    private int completed_programs;
    @Column(nullable = false)
    private boolean complete_goal;

    @JsonIgnore
    @ManyToMany(mappedBy = "goals")
    private Set<Program> programs;

    @OneToMany(mappedBy = "goal")
    private Set<Profile> profiles;
}
