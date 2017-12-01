package cn.totorotec.service.db.impl;

import cn.totorotec.entity.Role;
import cn.totorotec.entity.User;
import cn.totorotec.repository.RoleRepository;
import cn.totorotec.repository.UserRepository;
import cn.totorotec.service.db.RoleService;

import javax.annotation.Resource;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private UserRepository userRepository;

    @Override
    public List<User> assignedUsers(Role role) {
        return null;
    }

    @Override
    public List<Role> assignedRoles(User user) {
        return null;
    }
}
