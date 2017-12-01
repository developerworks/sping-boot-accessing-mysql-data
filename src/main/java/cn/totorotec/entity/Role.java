/**
 * 基于角色的访问控制, 角色是核心, 作为用户和权限的桥, 实现用户和权限的解耦.
 */
package cn.totorotec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter

public class Role extends AbstractEntity {
    private String name;
    private String description;

    /**
     * 角色可以被赋予多个用户
     */
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Set<User> users;

    /**
     * 一个角色包含多个权限
     */
    @ManyToMany
    @JoinTable(
        name = "role_permissions",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions;

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
