package cn.totorotec.service.db;

import cn.totorotec.entity.User;
import cn.totorotec.entity.UserDto;
import cn.totorotec.exceptions.UserAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends DatabaseService<User> {

    User findByUsername(String username);

    User createUser(UserDto userDto) throws UserAlreadyExistException;
}
