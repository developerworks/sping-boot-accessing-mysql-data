package cn.totorotec.service.db.impl;

import cn.totorotec.repository.RoleRepository;
import cn.totorotec.service.db.RoleService;
import org.springframework.beans.factory.annotation.Autowired;


public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
}
