package cn.totorotec.service;

import cn.totorotec.entity.User;
import cn.totorotec.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class UserService {

    @Resource
    private UserRepository userRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}
