package cn.totorotec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Setter
@Getter
public class Privilege extends AbstractEntity {
    private String name;

    private String description;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

    public Privilege(String name) {
        this.name = name;
    }

    public Privilege(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
