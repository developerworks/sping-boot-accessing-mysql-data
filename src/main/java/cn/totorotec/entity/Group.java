package cn.totorotec.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
public class Group extends AbstractEntity {

    private String name;
    private String description;

    /**
     * 用户和组的关系由用户中的属性 groups 来维护
     */
    @ManyToMany(mappedBy = "groups", fetch = FetchType.EAGER)
    private Set<User> users;

    /**
     * 组和角色的关系由本类维护
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "group_role", joinColumns = {@JoinColumn(name = "group_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    public void addRole(Role role) {
        if (ObjectUtils.isEmpty(role.getId())) {
            throw new IllegalArgumentException("role id can not be null.");
        }
        if (this.roles == null) {
            this.roles = new HashSet<>();
        }
        this.roles.add(role);
    }

    public void addRole(Set<Role> roleSet) {
        if (this.roles == null) {
            this.roles = new HashSet<>();
        }
        this.roles.addAll(roleSet);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Group{");
        sb.append("id=").append(this.getId());
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}
