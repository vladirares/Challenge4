package com.playtika.challenge4.repositories;

import com.playtika.challenge4.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    @Query(value = "SELECT * FROM players  WHERE player_accepts_newsletter = TRUE ORDER BY player_name DESC",nativeQuery = true)
    List<Player> getRegisteredPlayers();

    @Query(value = "SELECT * FROM players p WHERE p.player_no_played_games >= :lowValue AND p.player_no_played_games <= :highValue  ",nativeQuery = true)
    List<Player> getPlayerWithGamesBetween(int lowValue, int highValue);

    @Query(value = "SELECT * FROM players p WHERE p.player_no_played_games >= :value  ",nativeQuery = true)
    List<Player> getPlayerWithGamesAbove(int value);

    @Query(value = "SELECT * FROM players  ORDER BY player_name ",nativeQuery = true)
    List<Player> getSortedPlayers();

    @Query(value = "SELECT * FROM players  ORDER BY player_no_played_games DESC ",nativeQuery = true)
    List<Player> getPlayersByNumberOfGames();


}
