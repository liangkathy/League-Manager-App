package com.example.leaguemanagerapp.controller;

import com.example.leaguemanagerapp.model.Player;
import com.example.leaguemanagerapp.model.Team;
import com.example.leaguemanagerapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    //GET
    //get all teams
    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    //get a team by id
    @GetMapping("/teams/{id}")
    public Team getTeamById(@PathVariable Integer id) throws Exception {
        return teamService.getTeamById(id);
    }

    //POST
    //create a new team
    @PostMapping("/teams")
    public Team createTeam(@RequestBody Team team) throws Exception {
        return teamService.createTeam(team);
    }

    //PUT
    //update a team
    @PutMapping("/teams/{id}")
    public Team updateTeam(@PathVariable Integer id, @RequestBody Team team) throws Exception {
        return teamService.updateTeam(id, team);
    }

    //DELETE
    //delete a team
    @DeleteMapping("/teams/{id}")
    public String deleteTeam(@PathVariable Integer id){
        return teamService.deleteTeam(id);
    }

    //ADDITIONAL FUNCTIONALITY
    //add player to a team
    @PostMapping("/teams/{id}/players")
    public Team addPlayerToTeam(@PathVariable Integer id, @RequestBody Player player) throws Exception {
        return teamService.addPlayerToTeam(id, player);
    }

    //delete a player from a team
    @DeleteMapping("/teams/{id}/players/{playerId}")
    public void deletePlayerFromTeam(@PathVariable Integer id, @PathVariable Integer playerId) throws Exception {
        teamService.deletePlayerFromTeam(id, playerId);
    }

}
