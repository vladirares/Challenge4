package com.playtika.challenge4.controllers;


import com.playtika.challenge4.models.Player;
import com.playtika.challenge4.services.BingoNumberGenerator;
import com.playtika.challenge4.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/play")
public class GeneratorController {
    @Autowired
    PlayerService playerService;
    @Autowired
    BingoNumberGenerator generator;


    @GetMapping
    @RequestMapping("/{playerId}/cards/{noCards}")
    public boolean giveCards(@PathVariable long playerId, @PathVariable int noCards) {
        return playerService.giveCards(playerId,noCards);
    }


}
