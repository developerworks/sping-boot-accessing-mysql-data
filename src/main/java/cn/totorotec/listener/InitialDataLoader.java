/**
 * 整个应用开始运行时执行
 */

package cn.totorotec.listener;

import cn.totorotec.entity.Privilege;
import cn.totorotec.entity.Resource;
import cn.totorotec.entity.Role;
import cn.totorotec.entity.User;
import cn.totorotec.repository.PrivilegeRepository;
import cn.totorotec.repository.ResourceRepository;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private ResourceRepository resourceRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {
            logger.info("Data was loaded, don't repeat load data.");
            return;
        }

        // 权限定义(CRUD)
        Privilege create = createPrivilegeIfNotFound("POST/CREATE", "创建");
        Privilege read = createPrivilegeIfNotFound("GET/READ", "读取");
        Privilege update = createPrivilegeIfNotFound("PUT/UPDATE", "更新");
        Privilege delete = createPrivilegeIfNotFound("DELETE/DELETE", "删除");

        /**
         * 权限集合构成角色, 管理员可以创建,读取,更新,删除
         * 普通用户只能读
         */
        logger.info("定义角色和权限");
        Set<Privilege> adminPrivileges = new HashSet<>();
        adminPrivileges.add(create);
        adminPrivileges.add(read);
        adminPrivileges.add(update);
        adminPrivileges.add(delete);

        Set<Privilege> userPrivileges = new HashSet<>();
        userPrivileges.add(read);

        logger.info("创建角色");
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", userPrivileges);

        logger.info("创建资源");

        createResourceIfNotFound("User", "/users", "用户资源");
        createResourceIfNotFound("Role", "/roles", "角色资源");
        createResourceIfNotFound("Resource", "/resources", "资源列表");
        createResourceIfNotFound("Privilege", "/privileges", "权限");
        createResourceIfNotFound("Group", "/groups", "用户组");

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
    protected Privilege createPrivilegeIfNotFound(String name, String description) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name, description);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    protected Role createRoleIfNotFound(String name, Set<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    protected Resource createResourceIfNotFound(String name, String url, String description) {
        Resource resource = resourceRepository.findByName(name);
        if(resource == null) {
            resource = new Resource(name, url, description);
            resourceRepository.save(resource);
        }
        return resource;
    }
}
