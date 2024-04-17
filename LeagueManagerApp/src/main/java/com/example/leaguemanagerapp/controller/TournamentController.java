package com.example.leaguemanagerapp.controller;

import com.example.leaguemanagerapp.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TournamentController {

    @Autowired
    TournamentService tournamentService;
}
