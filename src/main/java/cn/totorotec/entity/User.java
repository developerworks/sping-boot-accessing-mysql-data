package cn.totorotec.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends AbstractEntity {

    @Length(min = 6, max = 12)
    private String name;

    @Email
    private String email;

    private String username;

    @Transient
    private String password;

    private String encryptedPassword;

    private Integer failedLoginAttempts = 0;

    private Boolean enabled;

    /**
     * 角色
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    /**
     * 职权
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authorities", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "authority_id")})
    private Set<Authority> authorities;

    /**
     * 组
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_groups", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private Set<Group> groups;

}
