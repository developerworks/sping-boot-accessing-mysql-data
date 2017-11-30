package cn.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
@Setter
@Getter
public abstract class AbstractEntityStringPK implements Serializable {

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
