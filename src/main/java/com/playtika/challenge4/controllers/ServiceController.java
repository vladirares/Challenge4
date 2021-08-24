package com.playtika.challenge4.controllers;


import com.playtika.challenge4.config.BingoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
public class ServiceController {

    @Autowired
    BingoSettings bingoSettings;

    @GetMapping
    public BingoSettings getSettings() {
        return bingoSettings;
    }

    @RequestMapping("/version")
    @GetMapping
    public String getVersion() {
        return "version: " + bingoSettings.getVersion();
    }

}