package com.example.leaguemanagerapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;


    @JsonIgnore
    @ManyToOne //(cascade = CascadeType.PERSIST) - this might be able to be excluded
    @JoinColumn (name = "team_id", nullable =false)
    private Team team;

}
