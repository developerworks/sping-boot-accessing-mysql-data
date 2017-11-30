/**
 * PagingAndSortingRepository 接口继承于 CrudRepository 接口, 拥有CrudRepository 接口的所有方法,并且有两个特有的方法
 * <p>
 * - 分页方法
 * - 排序方法
 * <p>
 * 这两个方法的缺陷是不能有筛选条件
 * <p>
 * 方法重载是指在一个类中定义多个同名的方法，但要求每个方法具有不同的参数的类型或参数的个数。
 * 调用重载方法时，Java编译器能通过检查调用的方法的参数类型和个数选择一个恰当的方法
 */
package cn.totorotec.repository;

import cn.totorotec.entity.QUser;
import cn.totorotec.entity.User;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {

    User findByUsername(String username);

    User findByEmail(String email);

    User findByUsernameContains(String username);


    /**
     * https://lufficc.com/blog/spring-boot-jpa-querydsl
     * http://blog.csdn.net/liuchuanhong1/article/details/70244261
     * http://hrps.me/2016/11/18/spring-data-jpa/
     * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#query-by-example
     * @param bindings
     * @param user
     */
    @Override
    default void customize(QuerydslBindings bindings, QUser user) {
        bindings.bind(user.name).first(StringExpression::containsIgnoreCase);
    }
}
