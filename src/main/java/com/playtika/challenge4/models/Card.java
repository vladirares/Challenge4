package com.playtika.challenge4.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "card_serial")
    private String name;

    @Column(name = "card_no_numbers")
    private int noNumbers;

    @Column(name = "card_generated_date")
    private Date generatedDate;

    @ManyToOne
    @JoinColumn(name = "player_id",insertable = false,updatable = false)
    private Player player;

//    @OneToMany
//    @JoinColumn(name = "card_id")
//    private List<BingoNumber> bingoNumbers;

//    public List<BingoNumber> getBingoNumbers() {
//        return bingoNumbers;
//    }
//
//    public void setBingoNumbers(List<BingoNumber> bingoNumbers) {
//        this.bingoNumbers = bingoNumbers;
//    }


    @ManyToMany
    @JoinTable(name="card_numbers",
            joinColumns = @JoinColumn(name="card_id",referencedColumnName = "card_id"),
            inverseJoinColumns = @JoinColumn(name="number_id",referencedColumnName = "number_id"))
    private List<BingoNumber> numbers;

    public List<BingoNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<BingoNumber> numbers) {
        this.numbers = numbers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoNumbers() {
        return noNumbers;
    }

    public void setNoNumbers(int noNumbers) {
        this.noNumbers = noNumbers;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}