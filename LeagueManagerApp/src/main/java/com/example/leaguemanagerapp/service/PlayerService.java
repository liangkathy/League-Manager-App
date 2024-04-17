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


    public List<Player> getPlayerbyID(Integer id) {
        return playerRepository.findPlayerById(id);
    }


    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }


    public Player addplayer(Player player) {
        return playerRepository.save(player);
    }
public Player updatePlayer (){
        Player currentPlayer = playerRepository.findPlayerById(id);
        currentPlayer.setName(currentPlayer.getName());
        currentPlayer.setTeam(currentPlayer.getTeam());
        return playerRepository.save((currentPlayer));

}
    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }
}
