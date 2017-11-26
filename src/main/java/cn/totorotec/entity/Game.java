package cn.totorotec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Game extends AbstractEntityStringPK {
    @Column(length = 32)
    private String name;

    @ManyToMany(mappedBy = "games")
    private Set<Player> players = new HashSet<Player>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

}
