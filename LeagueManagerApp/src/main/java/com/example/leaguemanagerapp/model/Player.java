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
    @ManyToOne /*(cascade = CascadeType.PERSIST) WE do nOT want this here because we want the cascade to persist on the team
    Because All teams will have players but not all players will have/need/want teams. So the business logic is to update on team
    and not on player */
    @JoinColumn (name = "team_id") //nullable =false removed because we can have a player without them being on a team.
    private Team team;

}
