package cn.totorotec.service.security.impl;

import cn.totorotec.entity.*;
import cn.totorotec.service.db.RoleService;
import cn.totorotec.service.db.UserService;
import cn.totorotec.service.security.Review;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ReviewImpl implements Review {

    @Autowired
    private UserService userService;

    @Autowired
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
    public Set<Permission> rolePermissions(Operation operation, Resource resource) {
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
    public Set<Operation> roleOperationsOnObject(Role role, Resource resource) {
        return null;
    }

    @Override
    public Set<Operation> userOperationsOnObject(User user, Resource resource) {
        return null;
    }
}
