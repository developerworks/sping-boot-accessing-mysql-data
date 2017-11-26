/**
 * @MappedSuperclass 实体基类
 * <p>
 * 用于保存所有数据库表公共的字段, 标注为@MappedSuperclass的类不会映射到数据库表, 它是一个不完整的实体.
 * 其拥有的熟悉会被子类映射到数据库表的列(Column)
 * <p>
 * 本类创建了一个三个公共的字段
 * <p>
 * - id
 * - created_at
 * - is_deleted
 * <p>
 * MappedSuperclass 实体的限制
 * <p>
 * - 不能使用 @Entity 或 @Table标注
 * - 不存在对应的数据库表
 * <p>
 * 参考资料
 * <p>
 * - http://blog.csdn.net/qq_527235890/article/details/70196396
 */

package cn.totorotec.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer created_at;
    private Integer is_deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Integer created_at) {
        this.created_at = created_at;
    }

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

}
