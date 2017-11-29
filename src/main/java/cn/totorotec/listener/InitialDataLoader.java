/**
 * 整个应用开始运行时执行
 */

package cn.totorotec.listener;

import cn.totorotec.entity.Privilege;
import cn.totorotec.entity.Role;
import cn.totorotec.entity.User;
import cn.totorotec.repository.PrivilegeRepository;
import cn.totorotec.repository.RoleRepository;
import cn.totorotec.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Component

public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(InitialDataLoader.class);

    /**
     * ContextRefreshedEvent 可能会触发多次, 这里我们设置一个布尔标记只执行一次数据加载.
     */
    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {
            logger.info("Data was loaded, don't repeat load data.");
            return;
        }

        // 权限定义(CRUD)
        Privilege create = createPrivilegeIfNotFound("POST/CREATE");
        Privilege read = createPrivilegeIfNotFound("GET/READ");
        Privilege update = createPrivilegeIfNotFound("PUT/UPDATE");
        Privilege delete = createPrivilegeIfNotFound("DELETE/DELETE");

        /**
         * 权限集合构成角色, 管理员可以创建,读取,更新,删除
         * 普通用户只能读
         */
        logger.info("定义角色和权限");
        List<Privilege> adminPrivileges = Arrays.asList(create, read, update, delete);
        List<Privilege> userPrivileges = Arrays.asList(read);

        logger.info("创建角色");
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", userPrivileges);

        logger.info("创建有指定角色的用户");
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        User user = new User();
        user.setPassword("test");
        user.setUsername("q31514266");
        user.setEmail("developerworks@163.com");
        user.setRoles(Arrays.asList(adminRole));
        user.setEnabled(true);
        userRepository.save(user);
        alreadySetup = true;

    }

    @Transactional
    protected Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    protected Role createRoleIfNotFound(String name, List<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
