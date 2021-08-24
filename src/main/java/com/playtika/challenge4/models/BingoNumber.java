package com.playtika.challenge4.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bingo_numbers")
public class BingoNumber {
    @Id
    @Column(name = "number_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number_column")
    private String noColumn;

    @Column(name = "number_value")
    private int noValue;

    @JsonIgnore
    @ManyToMany(mappedBy = "numbers")
    private List<Card> cards;

//    @ManyToOne
//    @JoinColumn(name = "card_id",insertable = false,updatable = false)
//    private Card card;

    public BingoNumber(){

    }

    public BingoNumber(String noColumn, int noValue) {
        this.noColumn = noColumn;
        this.noValue = noValue;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getNoValue() {
        return noValue;
    }

    public void setNoValue(int noValue) {
        this.noValue = noValue;
    }

    public String getNoColumn() {
        return noColumn;
    }

    public void setNoColumn(String noColumn) {
        this.noColumn = noColumn;
    }

    //    public Card getCard() {
//        return card;
//    }
//
//    public void setCard(Card card) {
//        this.card = card;
//    }
}