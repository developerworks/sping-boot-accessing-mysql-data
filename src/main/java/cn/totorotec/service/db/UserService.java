package cn.totorotec.service.db;

import cn.totorotec.entity.User;

public interface UserService extends DatabaseService<User> {

    User findByUsername(String username);
}
