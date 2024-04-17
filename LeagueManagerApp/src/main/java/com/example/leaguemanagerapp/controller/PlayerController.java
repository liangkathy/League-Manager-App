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
    return playerService.getPlayerbyID(id); }
}
    //POST - Create a new player
@PostMapping("/Players")
public Player createPlayer (@RequestBody Player player) {
    return playerService.addplayer(player);
}

    //PUT

    //Del

    //More advanced Operations
} //last closing bracket
