package cn.totorotec.service.db;

import cn.totorotec.entity.User;
import cn.totorotec.exceptions.UserAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends DatabaseService<User> {

    User findByUsername(String username);

    User findByEmail(String email);

    User createUser(User user) throws UserAlreadyExistException;
}
