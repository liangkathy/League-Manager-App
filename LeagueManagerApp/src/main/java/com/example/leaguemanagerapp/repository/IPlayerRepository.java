package com.example.leaguemanagerapp.repository;
import com.example.leaguemanagerapp.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerRepository extends JpaRepository <Player, Integer> {
}