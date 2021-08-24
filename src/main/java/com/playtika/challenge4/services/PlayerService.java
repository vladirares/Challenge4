package com.playtika.challenge4.services;


import com.playtika.challenge4.models.Card;
import com.playtika.challenge4.models.Player;
import com.playtika.challenge4.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    BingoNumberGenerator generator;

    @Autowired
    CardService cardService;

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

    public boolean createPlayer(Player player) {
        if (player != null && player.getAge() >= 18) {
            Player p = playerRepository.saveAndFlush(player);
            return true;
        } else {
            return false;
        }
    }

    public boolean updatePlayer(Player player) {
        Optional<Player> existingPlayer = playerRepository.findById(player.getId());
        if (existingPlayer.isEmpty()) {
            return false;
        }
        existingPlayer.get().setName(player.getName());
        existingPlayer.get().setAge(player.getAge());
        existingPlayer.get().setGender(player.getGender());
        playerRepository.saveAndFlush(existingPlayer.get());
        return true;
    }

    public List<Player> getSortedPlayers() {
        return playerRepository.getSortedPlayers();
    }

    public List<Player> getPlayersByGamesPlayed() {
        return playerRepository.getPlayersByNumberOfGames();
    }

    public List<Player> getPlayersWithGamesBetween(int lowVal, int highVal) {
        return playerRepository.getPlayerWithGamesBetween(lowVal, highVal);
    }

    public boolean registerToNewsLetter(long id, boolean register) {
        Optional<Player> existingPlayer = playerRepository.findById(id);
        if (existingPlayer.isPresent()) {
            existingPlayer.get().setAcceptsNewsletter(register);
            playerRepository.saveAndFlush(existingPlayer.get());
            return true;
        }
        return false;
    }

    public boolean giveCards(long playerId, int noCards){
        Player player = findById(playerId);
        try {
            List<Card> cards = generator.generateCards(noCards).get();
            player.setCards(cardService.createCards(cards));
            player.setNoPlayedGames(player.getNoPlayedGames()+1);
            playerRepository.saveAndFlush(player);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }



}