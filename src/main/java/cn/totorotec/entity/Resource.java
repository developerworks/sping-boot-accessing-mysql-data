/**
 * 资源, NIST RBAC中的对象是被保护的东西, 在Java里面为避免名称冲突, 使用Resource做为Object. 对象属性是和业务相关的,
 * 不同的业务系统有不同的属性,所以对于Resource来说需要依据业务场景来具体设计和实现.
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

//    /**
//     * 一个资源对应哪些角色可以访问
//     */
//    @ManyToMany(mappedBy = "resources", fetch = FetchType.EAGER)
//    private List<Role> roles;

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
