/**
 * PagingAndSortingRepository 接口继承于 CrudRepository 接口, 拥有CrudRepository 接口的所有方法,并且有两个特有的方法
 * <p>
 * - 分页方法
 * - 排序方法
 * <p>
 * 这两个方法的缺陷是不能有筛选条件
 *
 * 方法重载是指在一个类中定义多个同名的方法，但要求每个方法具有不同的参数的类型或参数的个数。
 * 调用重载方法时，Java编译器能通过检查调用的方法的参数类型和个数选择一个恰当的方法
 */
package cn.totorotec.repository;

import cn.totorotec.entity.User;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

//    @Override
//    Iterable<User> findAll(Sort sort) {
//
//    }
//
//    @Override
//    Page<User> findAll(Pageable pageable) {
//
//    }
}
