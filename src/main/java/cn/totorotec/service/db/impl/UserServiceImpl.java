package cn.totorotec.service.db.impl;

import cn.totorotec.entity.User;
import cn.totorotec.repository.UserRepository;
import cn.totorotec.service.db.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

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

}
