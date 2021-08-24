package com.playtika.challenge4.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;

@Component()
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@PropertySource("classpath:bingo.properties")
public class BingoSettings {

    @Value("${service.version:0.0.0}")
    private String version;

    @Value("${service.description}")
    private String description;

    @Value("${no.max.players}")
    private int maxPlayers;

    @Value("${service.developer.name}")
    private String developers;

    private Date lastRun;

    @PostConstruct
    public void setLastRun(){
        lastRun = new Date();
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public String getDevelopers() {
        return developers;
    }

    public Date getLastRun() {
        return lastRun;
    }
}
