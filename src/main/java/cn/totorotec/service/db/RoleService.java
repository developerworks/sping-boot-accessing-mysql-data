package cn.totorotec.service.db;

import cn.totorotec.entity.Role;
import cn.totorotec.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService extends DatabaseService<Role> {

    /**
     * 获取一个角色的用户列表
     *
     * @param role
     * @return
     */
    List<User> assignedUsers(Role role);

    /**
     * 获取一个用户的所有角色
     *
     * @param user
     * @return
     */
    List<Role> assignedRoles(User user);
}
