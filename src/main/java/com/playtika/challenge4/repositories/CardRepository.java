package com.playtika.challenge4.repositories;

import com.playtika.challenge4.models.Card;
import com.playtika.challenge4.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {
    @Query(value = "SELECT * FROM cards  WHERE card_serial = :serial",nativeQuery = true)
    Card getCardWithSerial(String serial);

    @Query(value = "SELECT COUNT( player_id) FROM cards  WHERE card_generated_date >= :date GROUP BY player_id",nativeQuery = true)
    int getNOActiveUsers(Date date);

}
