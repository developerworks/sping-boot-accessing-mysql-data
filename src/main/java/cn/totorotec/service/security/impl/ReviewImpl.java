package cn.totorotec.service.security.impl;

import cn.totorotec.entity.*;
import cn.totorotec.service.db.RoleService;
import cn.totorotec.service.db.UserService;
import cn.totorotec.service.security.Review;

import javax.annotation.Resource;
import java.util.Set;

public class ReviewImpl implements Review {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Override
    public Set<User> assignedUsers(Role role) {
        return null;
    }

    @Override
    public Set<Role> assignedRoles(User user) {
        return null;
    }

    @Override
    public Set<Permission> rolePermissions(Operation operation, Object object) {
        return null;
    }

    @Override
    public Set<Permission> userPermissions(User user) {
        return null;
    }

    @Override
    public Set<Role> sessionRoles(Session session) {
        return null;
    }

    @Override
    public Set<Permission> sessionPermissions(Session session) {
        return null;
    }

    @Override
    public Set<Operation> roleOperationsOnObject(Role role, Object object) {
        return null;
    }

    @Override
    public Set<Operation> userOperationsOnObject(User user, Object object) {
        return null;
    }
}
