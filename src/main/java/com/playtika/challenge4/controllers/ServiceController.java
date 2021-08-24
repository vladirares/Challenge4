package com.playtika.challenge4.controllers;


import com.playtika.challenge4.config.BingoSettings;
import com.playtika.challenge4.services.CardService;
import com.playtika.challenge4.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api/info")
public class ServiceController {

    @Autowired
    BingoSettings bingoSettings;

    @Autowired
    PlayerService playerService;

    @Autowired
    CardService cardService;

    @GetMapping
    public BingoSettings getSettings() {
        return bingoSettings;
    }

    @RequestMapping("/version")
    @GetMapping
    public String getVersion() {
        return "version: " + bingoSettings.getVersion();
    }

    @RequestMapping("/noplayers")
    @GetMapping
    public String getNoPlayers() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        Date dateBefore = cal.getTime();
        return "players: " + cardService.getActiveUsers(dateBefore);
    }

}