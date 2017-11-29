package cn.totorotec.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Privilege extends AbstractEntity {
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Privilege(String name) {
        this.name = name;
    }
}
