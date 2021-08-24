package com.playtika.challenge4.services;

import com.playtika.challenge4.models.BingoNumber;
import com.playtika.challenge4.models.BingoNumberColumn;
import com.playtika.challenge4.models.Card;
import com.playtika.challenge4.models.Player;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class BingoNumberGenerator {

    public static final int NO_NUMBERS = 24;
    private Random random;
    @Async
    public CompletableFuture<List<Card>> generateCards(int number) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Card card = new Card();
            card.setNoNumbers(NO_NUMBERS);
            card.setGeneratedDate(new Date());
            card.setSerial(UUID.randomUUID().toString());
            card.setNumbers(generateNumbers());
            cards.add(card);
        }

        return CompletableFuture.completedFuture(cards);
    }


    private List<BingoNumber> generateNumbers() {
        random = new Random();
        Map<BingoNumberColumn, Set<Integer>> generatedNumbers = new HashMap<>();
        for (BingoNumberColumn column : BingoNumberColumn.values()) {
            generatedNumbers.put(column,new HashSet<>()) ;
            while (generatedNumbers.get(column).size() < (NO_NUMBERS + 1) / 5) {
                generatedNumbers.get(column).add(random.nextInt(column.getHighVal()) + column.getLowVal());
            }
        }
        Set<Integer> Nnumbers = generatedNumbers.get(BingoNumberColumn.N);
        List<Integer> Nnumber = new ArrayList<>(Nnumbers);
        Nnumber.remove(0);
        generatedNumbers.put(BingoNumberColumn.N,new HashSet<>(Nnumber));
        List<BingoNumber> numbers = new ArrayList<>();
        for(BingoNumberColumn column : BingoNumberColumn.values()){
            for(Integer val : generatedNumbers.get(column)){
                numbers.add(new BingoNumber(column.toString(),val));
            }
        }
        return numbers;
    }



}
