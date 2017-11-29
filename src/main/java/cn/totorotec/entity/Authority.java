/**
 * 职权, 权限实体
 **
 * 可以把职权 Authority 当做是一个以字符串标识的 "Permission" 或 一个 "Right".
 */
package cn.totorotec.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Authority extends AbstractEntityStringPK {

    @Basic
    @Column(name = "authority_name", length = 100)
    private String authorityName;

    @Basic
    @Column(name = "authority_description", length = 1024)
    private String authorityDescription;

    /**
     * 哪些用户有这个权限, 通过User.authorities属性进行描述
     */
    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityDescription() {
        return authorityDescription;
    }

    public void setAuthorityDescription(String authorityDescription) {
        this.authorityDescription = authorityDescription;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
