package com.example.leaguemanagerapp.controller;

import com.example.leaguemanagerapp.model.Player;
import com.example.leaguemanagerapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;

    //BASIC CRUD

    //GET - Retrieve a player by ID
    @GetMapping("/players/{id}")
    public List<Player> getPlayerbyID(@PathVariable int id) {
        return playerService.getPlayerbyID(id);
    }

    //Get ALL players
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    //POST - Create a new player
    @PostMapping("/players")
    public Player createPlayer(@RequestBody Player player) {
        return playerService.addplayer(player);
    }

    //PUT - Update player by ID
    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable Integer id @RequestBody Player player) {
        return playerService.updatePlayer(id, player);
    }

    //del - Delete a player
    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }

    //More advanced Operations
} //last closing bracket
