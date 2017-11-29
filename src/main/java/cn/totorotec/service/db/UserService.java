package cn.totorotec.service;

import cn.totorotec.entity.User;

public interface UserService extends DatabaseService<User> {

    User findByUsername(String username);
}
