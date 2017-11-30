/**
 * 职权, 权限实体
 * *
 * 可以把职权 Authority 当做是一个以字符串标识的 "Permission" 或 一个 "Right".
 */
package cn.totorotec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Setter
@Getter
public class Authority extends AbstractEntity {

    /**
     * 职权名称
     */
    private String name;

    /**
     * 职权描述
     */
    private String description;

    /**
     * 哪些用户有这个权限, 通过User.authorities属性进行描述
     * <p>
     * User.authorities
     */
    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

}
