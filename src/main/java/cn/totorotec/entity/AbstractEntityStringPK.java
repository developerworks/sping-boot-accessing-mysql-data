package cn.totorotec.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
public class AbstractEntityStringPK implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private String id;

    @Basic
    @Column(nullable = false, insertable = true, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createdAt;

    @Basic
    @Column(nullable = false, insertable = true, updatable = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp deletedAt;

    @Basic
    @Column(nullable = false, insertable = true, updatable = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * 持久化钩子: 当执行创建操作时, 在持久化到数据库之前, 更新实体对象的创建和修改时间
     */
    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        createdAt = updatedAt = new Timestamp(date.getTime());
    }

    /**
     * 持久化钩子: 当执行更新操作时, 在持久化到数据库之前, 更新实体对象的修改时间
     */
    @PreUpdate
    protected void onUpdate() {
        Date date = new Date();
        updatedAt = new Timestamp(date.getTime());
    }

    /**
     * 持久化钩子: 当执行删除操作时, 在持久化到数据库之前, 更新实体对象的删除时间
     */
    @PreRemove
    protected void onDelete() {
        Date date = new Date();
        deletedAt = new Timestamp(date.getTime());
    }
}
