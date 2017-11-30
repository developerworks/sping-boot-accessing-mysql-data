package cn.totorotec.service.db.impl;

import cn.totorotec.entity.User;
import cn.totorotec.entity.UserDto;
import cn.totorotec.exceptions.UserAlreadyExistException;
import cn.totorotec.repository.UserRepository;
import cn.totorotec.service.db.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

//    PasswordEncoder passwordEncoder =

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO:: 加密服务

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User register(UserDto userDto) throws UserAlreadyExistException {
        return null;
    }
}
