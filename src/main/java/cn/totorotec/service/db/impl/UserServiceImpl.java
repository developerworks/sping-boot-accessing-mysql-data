package cn.totorotec.service.db.impl;

import cn.totorotec.entity.User;
import cn.totorotec.entity.UserDto;
import cn.totorotec.exceptions.UserAlreadyExistException;
import cn.totorotec.repository.RoleRepository;
import cn.totorotec.repository.UserRepository;
import cn.totorotec.service.db.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    private PasswordEncoder bCryptPasswordEncoder;

//    PasswordEncoder passwordEncoder =


    // TODO:: 加密服务

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User createUser(UserDto userDto) throws UserAlreadyExistException {
        return null;
    }
}
