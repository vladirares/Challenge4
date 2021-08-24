package com.playtika.challenge4.services;


import com.playtika.challenge4.models.Player;
import com.playtika.challenge4.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player findById(long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.orElse(null);
    }

    public boolean deleteById(long id) {
        if (playerRepository.findById(id).isPresent()) {
            playerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Player createPlayer(Player player) {
        Player p = playerRepository.saveAndFlush(player);
        return p;
    }

    public boolean updatePlayer(Player player) {
        Optional<Player> existingPlayer = playerRepository.findById(player.getId());
        if (existingPlayer.isPresent()) {
            playerRepository.saveAndFlush(player);
            return true;
        }
        return false;
    }
}