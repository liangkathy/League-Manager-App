package com.example.leaguemanagerapp.controller;

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
    public Team createTeam(@RequestBody Team team){
        return teamService.createTeam(team);
    }

    //PUT
    //update a team
    @PutMapping("/teams/{id}")
    public Team updateTeam(Integer id, @RequestBody Team team) throws Exception {
        return teamService.updateTeam(id, team);
    }

    //DELETE
    //delete a team
    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@PathVariable Integer id){
        teamService.deleteTeam(id);
    }

}
