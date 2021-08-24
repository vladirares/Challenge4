package com.playtika.challenge4.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "player_name")
    private String name;

    @Column(name = "player_age")
    private int age;

    @Column(name = "player_username")
    private String username;

    @Column(name = "player_gender")
    private String gender;

    @Column(name = "player_no_played_games")
    private int noPlayedGames;

    @Column(name = "player_accepts_newsletter")
    private boolean acceptsNewsletter;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "player_id")
    private List<Card> cards;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNoPlayedGames() {
        return noPlayedGames;
    }

    public void setNoPlayedGames(int noPlayedGames) {
        this.noPlayedGames = noPlayedGames;
    }

    public boolean isAcceptsNewsletter() {
        return acceptsNewsletter;
    }

    public void setAcceptsNewsletter(boolean acceptsNewsletter) {
        this.acceptsNewsletter = acceptsNewsletter;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}