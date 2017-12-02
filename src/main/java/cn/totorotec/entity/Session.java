/**
 * http://blog.csdn.net/pandakong/article/details/8741948
 * <p>
 * 会话是一个运行时的权限集合
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

    /**
     * 控制一种设备类型只允许有一个会话, 比如微信可以同时登陆移动端,PC端
     */
    private Integer deviceType;

    @ManyToMany
    @JoinTable(name = "session_users")
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "session_roles")
    private Set<Role> roles;
}
