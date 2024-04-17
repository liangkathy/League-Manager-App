package com.example.leaguemanagerapp.controller;

import com.example.leaguemanagerapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;
}
