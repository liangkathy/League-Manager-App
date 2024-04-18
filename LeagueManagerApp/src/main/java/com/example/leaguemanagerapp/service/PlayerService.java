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


    public Player getPlayerbyID(Integer id) throws Exception {
        return playerRepository.findById(id).orElseThrow(()-> new Exception("Player with id " + id + " not found"));
    }


    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }




    public Player addplayer(Player player) throws Exception {
        if (player.getName().isEmpty() || player.getName().isBlank()) {
            throw new Exception("Player can not be empty");
        } else {
            return playerRepository.save(player);
        }

    }

    public Player updatePlayer(Integer id, Player player) throws Exception {
        Player currentPlayer = playerRepository.findById(id).orElseThrow(() -> new RuntimeException("IDd doesnt exist" +
                "."));
        if (player.getName().isBlank() || player.getName().isEmpty()) {
            throw new Exception("player name can not be empty");
        } else {
            currentPlayer.setName(player.getName());
            currentPlayer.setTeam(player.getTeam());
            return playerRepository.save((currentPlayer));
        }

    }

    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }
}
