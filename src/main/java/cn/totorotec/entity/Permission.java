package cn.totorotec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Setter
@Getter
public class Permission extends AbstractEntity {
    private String name;
    private Integer resourceId;
    private Integer operationId;

    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles;

    public Permission() {
    }

    /**
     * http://img.my.csdn.net/uploads/201112/2/0_1322820162b2DK.gif
     *
     * @param name
     * @param resourceId
     * @param operationId
     */
    public Permission(String name, Integer resourceId, Integer operationId) {
        this.name = name;
        this.resourceId = resourceId;
        this.operationId = operationId;
    }
}
