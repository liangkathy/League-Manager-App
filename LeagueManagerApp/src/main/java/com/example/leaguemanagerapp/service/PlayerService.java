package com.example.leaguemanagerapp.service;

import com.example.leaguemanagerapp.model.Player;
import com.example.leaguemanagerapp.repository.IPlayerRepository;
import com.example.leaguemanagerapp.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    IPlayerRepository playerRepository;

    //get player by id
    public Player getPlayerByID(Integer id) throws Exception {
        return playerRepository.findById(id).orElseThrow(()-> new Exception("Player with id " + id + " not found"));
    }

    //get all players
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    //create a new player
    public Player addplayer(Player player) throws Exception {
        if (player.getName().isEmpty() || player.getName().isBlank()) {
            throw new Exception("Player name cannot be empty");
        } else {
            return playerRepository.save(player);
        }

    }

    //update a player
    public Player updatePlayer(Integer id, Player player) throws Exception {
        Player currentPlayer = playerRepository.findById(id).orElseThrow(() -> new Exception("Player with id " + id + " not found"));

        if (player.getName().isBlank() || player.getName().isEmpty()) {
            throw new Exception("Player name cannot be empty");
        } else {
            currentPlayer.setName(player.getName());
            currentPlayer.setTeam(player.getTeam());
            return playerRepository.save((currentPlayer));
        }

    }

    //delete a player
    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }
}
