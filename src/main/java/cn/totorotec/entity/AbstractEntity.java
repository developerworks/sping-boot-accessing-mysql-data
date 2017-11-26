/**
 * @MappedSuperclass 实体基类
 *
 * 用于保存所有数据库表公共的字段, 标注为@MappedSuperclass的类不会映射到数据库表, 它是一个不完整的实体.
 * 其拥有的熟悉会被子类映射到数据库表的列(Column)
 *
 * 本类创建了一个三个公共的字段
 *
 * - id
 * - created_at
 * - is_deleted
 *
 * ## MappedSuperclass 实体的限制
 *
 * - 不能使用 @Entity 或 @Table标注
 * - 不存在对应的数据库表
 *
 * ## 参考资料

 * - http://blog.csdn.net/qq_527235890/article/details/70196396
 *
 * ## 多对多关系
 *
 * http://sourfeng.cn/2017/05/08/spring-data-jpa/
 *
 * 拆解多对多关系为两个多对一关系, 目的是为了扩展关系,比如关系的建立时间, 说明等信息.
 * 需要一个中间的独立实体
 */

package cn.totorotec.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

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
