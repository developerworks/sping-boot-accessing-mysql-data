package cn.totorotec.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player extends AbstractEntityBase {

    @Column(length = 32)
    private String name;

    @ManyToMany
    @JoinTable(name = "player_game", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> games = new HashSet<Game>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
