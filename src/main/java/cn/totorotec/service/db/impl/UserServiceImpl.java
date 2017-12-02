package cn.totorotec.service.db.impl;

import cn.totorotec.entity.Role;
import cn.totorotec.entity.User;
import cn.totorotec.exceptions.UserAlreadyExistException;
import cn.totorotec.repository.RoleRepository;
import cn.totorotec.repository.UserRepository;
import cn.totorotec.service.db.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    /**
     * TODO::QUESTION
     */
//    @Resource
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // TODO:: 加密服务

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user) throws UserAlreadyExistException {
//        user.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");

        Set<Role> roles = new HashSet<Role>();
        roles.add(adminRole);

        user.setRoles(roles);

        userRepository.save(user);

        return user;
    }

    @Override
    public User getById(Integer id) {
        return null;
    }
}
