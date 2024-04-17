package com.example.leaguemanagerapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tournament")
    @SequenceGenerator(name = "seq_tournament", allocationSize = 1)
    private Integer id;
    private String name;

    //many-to-many relationship with team
    @JsonIgnore
    @ManyToMany(mappedBy = "tournaments")
    private List<Team> teams = new ArrayList<>();

}
