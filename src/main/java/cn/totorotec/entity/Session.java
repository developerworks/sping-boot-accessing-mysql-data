/**
 * http://blog.csdn.net/pandakong/article/details/8741948
 *
 * 会话是一个运行时的权限集合
 *
 */
package cn.totorotec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class Session extends AbstractEntity {

    @ManyToMany
    @JoinTable(name = "session_users")
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "session_roles")
    private Set<Role> roles;
}
