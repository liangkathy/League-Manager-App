package com.example.leaguemanagerapp.service;

import com.example.leaguemanagerapp.model.Team;
import com.example.leaguemanagerapp.repository.IPlayerRepository;
import com.example.leaguemanagerapp.repository.ITeamRepository;
import com.example.leaguemanagerapp.repository.ITournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    ITeamRepository teamRepository;

    @Autowired
    IPlayerRepository playerRepository;

    @Autowired
    ITournamentRepository tournamentRepository;

    //get all teams
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    //get team by id
    public Team getTeamById(Integer id) throws Exception {
        return teamRepository.findById(id).orElseThrow(() -> new Exception("Team with id "+ id + " not found"));
    }

    //create a team
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    //update a team
    public Team updateTeam(Integer id, Team team) throws Exception {
        Team existingTeam = teamRepository.findById(id).orElseThrow(() -> new Exception("Team with id "+ id + " not found"));
        existingTeam.setName(team.getName());

//        existingTeam.setPlayers(team.getPlayers());
//        existingTeam.setTournaments(team.getTournaments());

        return teamRepository.save(existingTeam);
    }

    //delete a team
    public void deleteTeam(Integer id){
        teamRepository.deleteById(id);
    }
}
