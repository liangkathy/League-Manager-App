package com.example.leaguemanagerapp.service;

import com.example.leaguemanagerapp.model.Team;
import com.example.leaguemanagerapp.model.Tournament;
import com.example.leaguemanagerapp.repository.ITeamRepository;
import com.example.leaguemanagerapp.repository.ITournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentService {

    @Autowired
    ITournamentRepository tournamentRepository;

    @Autowired
    ITeamRepository teamRepository;

    //get all tournaments
    public List<Tournament> getAllTournaments(){
        return tournamentRepository.findAll();
    }

    //get tournament by id
    public Tournament getTournamentById(Integer id) throws Exception {
        return tournamentRepository.findById(id).orElseThrow(() -> new Exception("Tournament with id "+ id + " not found"));
    }

    //create a tournament
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    //update a tournament
    public Tournament updateTournament(Integer id, Tournament tournament) throws Exception {
        Tournament existingTournament = tournamentRepository.findById(id).orElseThrow(() -> new Exception("Tournament with id "+ id + " not found"));

        existingTournament.setName(tournament.getName());

        return tournamentRepository.save(existingTournament);
    }

    //delete a tournament
    public void deleteTournament(Integer id){
        tournamentRepository.deleteById(id);
    }


    //ADDITIONAL FUNCTIONALITY
    //add team to tournament
    public Tournament addTeamToTournament(Integer id, Team team) throws Exception {
        Tournament existingTournament = tournamentRepository.findById(id).orElseThrow(() -> new Exception("Tournament with id " + id + " not found"));
        List<Tournament> tournaments = new ArrayList<>();
        tournaments.add(existingTournament);

        team.setTournaments(tournaments);
        teamRepository.save(team);

        existingTournament.getTeams().add(team);
        return tournamentRepository.save(existingTournament);
    }


    //delete a team from a tournament
    public void deleteTeamFromTournament(Integer id, Integer teamId) throws Exception {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new Exception("Tournament with id " + id + " not found"));
        tournament.getTeams().removeIf(t -> t.getId() == teamId);

        Team team = teamRepository.findById(id).orElseThrow(() -> new Exception("Team with id " + id + " not found"));
        team.getTournaments().removeIf(t -> t.getId() == id);

        tournamentRepository.save(tournament);
        teamRepository.save(team);

    }



}
