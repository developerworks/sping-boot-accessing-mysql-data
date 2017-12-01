package cn.totorotec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter

public class Role extends AbstractEntity {
    private String name;
    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Set<User> users;

    @ManyToMany
    @JoinTable(
        name = "role_privileges",
        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id")
    )
    private Set<Privilege> privileges;
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
//    @JoinTable(
//        name = "role_resources",
//        joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
//        inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "id")}
//    )
//    private Set<Resource> resources;

    public Role() {

    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Role(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }


    public void addUser(User user) {
        if (!this.users.contains(user)) {
            this.users.add(user);
        }

        if (!user.getRoles().contains(this)) {
            user.getRoles().add(this);
        }
    }

    public void removeUser(User user) {
        this.users.remove(user);
        user.getRoles().remove(this);
    }

}
