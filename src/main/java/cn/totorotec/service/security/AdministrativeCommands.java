package cn.totorotec.service.security;

import cn.totorotec.entity.Operation;
import cn.totorotec.entity.Resource;
import cn.totorotec.entity.Role;
import cn.totorotec.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface AdministrativeCommands {

    /**
     * 添加一个用户
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 删除一个用户
     *
     * @param user
     */
    void deleteUser(User user);

    /**
     * 添加一个角色
     *
     * @param role
     */
    void addRole(Role role);

    /**
     * 删除一个角色
     *
     * @param role
     */
    void deleteRole(Role role);

    /**
     * Assign a role to a user
     * 分配一个角色给用户
     *
     * @param user
     * @param role
     */
    void assignUser(User user, Role role);

    /**
     * 取消一个用户的角色
     *
     * @param user
     * @param role
     */
    void deassignUser(User user, Role role);

    /**
     * 把对象 object 的操作权限 operation 赋予 role
     *
     * @param resource
     * @param operation
     * @param role
     */
    void grantPermission(Resource resource, Operation operation, Role role);

    /**
     * 吊销角色 role 在对象 object 上的 operation 操作权限
     *
     * @param operation
     * @param resource
     * @param role
     */
    void revokePermission(Operation operation, Resource resource, Role role);
}
