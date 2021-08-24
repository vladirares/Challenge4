package com.playtika.challenge4.controllers;


import com.playtika.challenge4.models.Player;
import com.playtika.challenge4.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAll() {
        if (playerService.findAll().size() < 1) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(playerService.findAll(), HttpStatus.OK);
        }

    }

    @GetMapping
    @RequestMapping("/{player_id}")
    public Player getPlayer(@PathVariable long player_id) {
        return playerService.findById(player_id);
    }

    @GetMapping
    @RequestMapping("/sorted")
    public List<Player> getPlayersSorted() {
        return playerService.getSortedPlayers();
    }

    @GetMapping
    @RequestMapping("/halloffame")
    public List<Player> getPlayersByGamesPlayed() {
        return playerService.getPlayersByGamesPlayed();
    }

    @GetMapping(params = {"min", "max"})
    public List<Player> getPlayerWithGamesBetween(@RequestParam int min, @RequestParam int max) {
        return playerService.getPlayersWithGamesBetween(min, max);
    }


    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<Player> createNewPlayer(@RequestBody Player player) {
        if(playerService.createPlayer(player)){
            return new ResponseEntity<>(player,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(player,HttpStatus.CONFLICT);
        }
    }


    @DeleteMapping
    @RequestMapping("/unregister/{playerId}")
    public ResponseEntity<Boolean> deletePlayer(@PathVariable long playerId) {
        if(playerService.deleteById(playerId)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @RequestMapping("/{playerId}/newsletter/register")
    public ResponseEntity<Boolean> registerToNewsLetter(@PathVariable long playerId) {
        if(playerService.registerToNewsLetter(playerId,true)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @RequestMapping("/{playerId}/newsletter/unregister")
    public ResponseEntity<Boolean> unregisterToNewsLetter(@PathVariable long playerId) {
        if(playerService.registerToNewsLetter(playerId,false)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @RequestMapping("/{playerId}/patch")
    public ResponseEntity<Boolean> updatePlayer(@RequestBody Player player) {
        if (playerService.findById(player.getId()) == null) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        } else {
            playerService.updatePlayer(player);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }


    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<>("error in player controller",HttpStatus.BAD_REQUEST);
    }


}
