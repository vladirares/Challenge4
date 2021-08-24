package com.playtika.challenge4.repositories;

import com.playtika.challenge4.models.Card;
import com.playtika.challenge4.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
