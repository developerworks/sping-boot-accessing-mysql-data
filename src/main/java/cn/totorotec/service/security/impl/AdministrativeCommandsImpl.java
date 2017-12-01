package cn.totorotec.service.security.impl;

import cn.totorotec.entity.Operation;
import cn.totorotec.entity.Role;
import cn.totorotec.entity.User;
import cn.totorotec.service.db.RoleService;
import cn.totorotec.service.db.UserService;
import cn.totorotec.service.security.AdministrativeCommands;

import javax.annotation.Resource;

public class AdministrativeCommandsImpl implements AdministrativeCommands {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void addRole(Role role) {

    }

    @Override
    public void deleteRole(Role role) {

    }

    @Override
    public void assignUser(User user, Role role) {

    }

    @Override
    public void deassignUser(User user, Role role) {

    }

    @Override
    public void grantPermission(Object object, Operation operation, Role role) {

    }

    @Override
    public void revokePermission(Operation operation, Object object, Role role) {

    }
}
