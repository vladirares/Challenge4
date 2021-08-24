package com.playtika.challenge4.repositories;

import com.playtika.challenge4.models.BingoNumber;
import com.playtika.challenge4.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BingoNumberRepository extends JpaRepository<BingoNumber,Long> {
}
