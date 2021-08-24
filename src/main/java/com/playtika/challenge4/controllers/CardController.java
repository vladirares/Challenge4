package com.playtika.challenge4.controllers;


import com.playtika.challenge4.models.Card;
import com.playtika.challenge4.models.Player;
import com.playtika.challenge4.services.BingoNumberGenerator;
import com.playtika.challenge4.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/cards")
public class CardController {
    @Autowired
    CardService cardService;

    @Autowired
    BingoNumberGenerator generator;

    @GetMapping
    public ResponseEntity<List<Card>> getAll() {
        if (cardService.findAll().size() < 1) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(cardService.findAll(), HttpStatus.OK);
        }

    }

    @GetMapping
    @RequestMapping("/{cardSerial}")
    public Card getCardWithSerial(@PathVariable String cardSerial){
        return cardService.findBySerialNumber(cardSerial);
    }

    @DeleteMapping
    @RequestMapping("/remove/{cardSerial}")
    public boolean deleteCardWithSerial(@PathVariable String cardSerial){
        return cardService.deleteBySerial(cardSerial);
    }

    @GetMapping(params = {"no"})
    @RequestMapping("/generate")
    public List<Card> getGeneratedCards(@RequestParam int no){
        try {
            return generator.generateCards(no).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @ExceptionHandler
//    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
//    public ResponseEntity<String> handleException(Exception e){
//        return new ResponseEntity<>("error in card controller",HttpStatus.BAD_REQUEST);
//    }


}