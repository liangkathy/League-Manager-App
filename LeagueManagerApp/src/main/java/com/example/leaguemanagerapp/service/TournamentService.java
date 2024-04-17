package com.example.leaguemanagerapp.service;

import com.example.leaguemanagerapp.repository.ITournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {

    @Autowired
    ITournamentRepository tournamentRepository;
}
