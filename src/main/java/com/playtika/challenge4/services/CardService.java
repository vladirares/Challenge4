package com.playtika.challenge4.services;

import com.playtika.challenge4.models.BingoNumber;
import com.playtika.challenge4.models.Card;
import com.playtika.challenge4.models.Player;
import com.playtika.challenge4.repositories.BingoNumberRepository;
import com.playtika.challenge4.repositories.CardRepository;
import com.playtika.challenge4.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BingoNumberRepository bingoNumberRepository;

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public List<Card> createCards(List<Card> cards) {
        for(Card card : cards){
            bingoNumberRepository.saveAll(card.getNumbers());
        }
        return cardRepository.saveAll(cards);
    }

    public Card findBySerialNumber(String serial) {
        return cardRepository.getCardWithSerial(serial);
    }

    public boolean deleteBySerial(String serial) {
        Card card = cardRepository.getCardWithSerial(serial);
        if (card != null) {
            cardRepository.deleteById(card.getId());
            return true;
        }
        return false;
    }

    public int getActiveUsers(Date date){
        return cardRepository.getNOActiveUsers(date);
    }

}