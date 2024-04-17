package com.example.leaguemanagerapp.repository;

import com.example.leaguemanagerapp.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITournamentRepository extends JpaRepository<Tournament, Integer> {
}
