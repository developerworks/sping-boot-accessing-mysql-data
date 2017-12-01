/**
 * ANSI INCITS 359-2004
 * <p>
 * 6.1.3 Review Functions for Core RBAC
 */
package cn.totorotec.service.security;

import cn.totorotec.entity.*;

import java.util.Set;

public interface Review {

    /**
     * Returns the set of users assigned to a given role
     * 获取一个角色的所有用户
     *
     * @param role
     * @return
     */
    Set<User> assignedUsers(Role role);

    /**
     * Returns the set of roles assigned to a given user
     * <p>
     * 获取一个用户的所有角色
     *
     * @param user
     * @return
     */
    Set<Role> assignedRoles(User user);

    /**
     * Returns the set of permissions (op, obj) granted to a given role
     * <p>
     * 返回赋予一个特定角色的权限集合
     *
     * @param operation
     * @param resource
     * @return
     */
    Set<Permission> rolePermissions(Operation operation, Resource resource);

    /**
     * Returns the permissions a given user gets through his/her assigned roles
     * <p>
     * 通过赋予他/她的角色, 返回一个特定用户的权限集合
     *
     * @param user
     * @return
     */
    Set<Permission> userPermissions(User user);

    /**
     * Returns the active roles associated with a session.
     * <p>
     * 返回与会话关联的活动角色集合
     *
     * @param session
     * @return
     */
    Set<Role> sessionRoles(Session session);

    /**
     * Returns the permissions of the session, i.e., the permissions assigned to its active roles.
     * <p>
     * 返回会话相关的权限集合, 例如分配给该会话的活动角色的权限.
     *
     * @param session
     * @return
     */
    Set<Permission> sessionPermissions(Session session);

    /**
     * Returns the set of operations a given role is permitted to perform on a given object
     * <p>
     * 返回给定角色在给定对象上允许的操作集合, 表示一个角色在一个对象上运行执行哪些操作
     *
     * @param role
     * @param resource
     * @return
     */
    Set<Operation> roleOperationsOnObject(Role role, Resource resource);

    /**
     * Returns the set of operations a given user is permitted to perform on a given object,
     * obtained either directly or through his/her assigned roles.
     * <p>
     * 返回用户在对象上允许执行的操作集合, 直接的获取, (或者)通过分配的角色获取.
     *
     * @param user
     * @param resource
     * @return
     */
    Set<Operation> userOperationsOnObject(User user, Resource resource);
}
