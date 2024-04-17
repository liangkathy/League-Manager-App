package com.example.leaguemanagerapp.service;

import com.example.leaguemanagerapp.repository.IPlayerRepository;
import com.example.leaguemanagerapp.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    IPlayerRepository playerRepository;
    @Autowired
    ITeamRepository teamRepository; //for later

}
