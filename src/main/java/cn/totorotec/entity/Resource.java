/**
 * 资源
 */
package cn.totorotec.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

import lombok.*;

@Entity
@Getter
@Setter
public class Resource extends AbstractEntity {

    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源地址
     */
    private String url;

    /**
     * 资源描述
     */
    private String description;

    /**
     * 一个资源对应哪些角色可以访问
     */
    @ManyToMany(mappedBy = "resources", fetch = FetchType.EAGER)
    private List<Role> roles;

    public Resource() {
    }

    public Resource(String name) {
        this.name = name;
    }

    public Resource(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Resource(String name, String url, String description) {
        this.name = name;
        this.url = url;
        this.description = description;
    }

}
