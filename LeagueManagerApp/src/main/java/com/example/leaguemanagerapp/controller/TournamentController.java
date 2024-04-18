package com.example.leaguemanagerapp.controller;

import com.example.leaguemanagerapp.model.Player;
import com.example.leaguemanagerapp.model.Team;
import com.example.leaguemanagerapp.model.Tournament;
import com.example.leaguemanagerapp.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TournamentController {

    @Autowired
    TournamentService tournamentService;
    //GET
    //get all tournaments
    @GetMapping("/tournaments")
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    //get a tournament by id
    @GetMapping("/tournaments/{id}")
    public Tournament getTournamentById(@PathVariable Integer id) throws Exception {
        return tournamentService.getTournamentById(id);
    }

    //POST
    //create a new tournament
    @PostMapping("/tournaments")
    public Tournament createTournament(@RequestBody Tournament tournament) throws Exception {
        return tournamentService.createTournament(tournament);
    }

    //PUT
    //update a tournament
    @PutMapping("/tournaments/{id}")
    public Tournament updateTournament(@PathVariable Integer id, @RequestBody Tournament tournament) throws Exception {
        return tournamentService.updateTournament(id, tournament);
    }

    //DELETE
    //delete a tournament
    @DeleteMapping("/tournaments/{id}")
    public String deleteTournament(@PathVariable Integer id) throws Exception {
        return tournamentService.deleteTournament(id);
    }


    //ADDITIONAL FUNCTIONALITY
    //add new team to tournament
    @PostMapping("/tournaments/{id}/teams")
    public Tournament addTeamToTournament(@PathVariable Integer id, @RequestBody Team team) throws Exception {
        return tournamentService.addTeamToTournament(id, team);
    }

    //add existing team to tournament
    @PutMapping("/tournaments/{id}/teams/{teamId}")
    public Tournament addExistingTeamToTournament(@PathVariable Integer id, @PathVariable Integer teamId) throws Exception {
        return tournamentService.addExistingTeamToTournament(id, teamId);
    }


    //delete a team from a tournament
    @DeleteMapping("/tournaments/{id}/teams/{teamId}")
    public void deleteTeamFromTournament(@PathVariable Integer id, @PathVariable Integer teamId) throws Exception {
        tournamentService.deleteTeamFromTournament(id, teamId);
    }

    //get all teams in a tournament
    @GetMapping("/tournaments/{id}/teams")
    public List<Team> getAllTeamsFromTournament(@PathVariable Integer id) throws Exception {
        return tournamentService.getAllTeamsFromTournament(id);
    }


    //get a list of all the players in a tournament
    @GetMapping("/tournaments/{id}/players")
    public List<Player> getAllPlayersFromTournament(@PathVariable Integer id) throws Exception {
        return tournamentService.getAllPlayersFromTournament(id);
    }

}
