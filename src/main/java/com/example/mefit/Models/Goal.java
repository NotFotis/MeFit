package com.example.mefit.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private int id;
    @Column(name="goal_name",length = 50,nullable = false)
    private String name;
    @Column(name = "goal_start_date", length = 50,nullable = false)
    private Date start_date;
    @Column(name = "goal_end_date", length = 50,nullable = false)
    private Date end_date;
    @Column(name = "goal_total_programs")
    private int total_programs;
    @Column(name = "goal_completed_programs")
    private int completed_programs;
    @Column(name = "goal_achieved")
    private Boolean achieved;

    @ManyToMany
    @JoinTable(
            name = "program_goal",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "goal_id")
    )
    private Set<Program> program;

}