package cn.totorotec.service.db;

import cn.totorotec.entity.User;
import cn.totorotec.entity.UserDto;
import cn.totorotec.exceptions.UserAlreadyExistException;

public interface UserService extends DatabaseService<User> {

    User findByUsername(String username);

    User register(UserDto userDto) throws UserAlreadyExistException;
}
