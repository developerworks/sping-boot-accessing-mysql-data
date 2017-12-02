/**
 * 整个应用开始运行时执行
 */

package cn.totorotec.component.listener;

import cn.example.HelloProperties;
import cn.totorotec.entity.*;
import cn.totorotec.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
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
    private OperationRepository operationRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private PermissionRepository permissionRepository;


//    @Autowired
//    private HelloProperties helloProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        helloProperties.getMsg();

        if (alreadySetup) {
            logger.info("Data was loaded, don't repeat load data.");
            return;
        }

        logger.info("定义操作");

        Operation op_create = createOperationIfNotFound("POST/CREATE", "创建");
        Operation op_read = createOperationIfNotFound("GET/READ", "读取");
        Operation op_update = createOperationIfNotFound("PUT/UPDATE", "更新");
        Operation op_delete = createOperationIfNotFound("DELETE/DELETE", "删除");
        Operation op_all = createOperationIfNotFound("ALL", "所有");

        logger.info("定义权限");
        Permission createUser = createPermissionIfNotFound("创建用户", 1, 1);
        Permission readUser = createPermissionIfNotFound("读取用户", 1, 2);
        Permission updateUser = createPermissionIfNotFound("修改用户", 1, 3);
        Permission deleteUser = createPermissionIfNotFound("删除用户", 1, 4);

        logger.info("=== 定义角色 ===");

        logger.info("管理员角色的权限");
        Set<Permission> adminPermissions = new HashSet<Permission>();
        adminPermissions.add(createUser);
        adminPermissions.add(readUser);
        adminPermissions.add(updateUser);
        adminPermissions.add(deleteUser);

        logger.info("用户角色的权限");
        Set<Permission> userPermissions = new HashSet<Permission>();
        userPermissions.add(readUser);

        createRoleIfNotFound("ROLE_ADMIN", adminPermissions);
//        createRoleIfNotFound("ROLE_DISTRIBUTOR", )
        createRoleIfNotFound("ROLE_USER", userPermissions);

        logger.info("创建资源");
        createResourceIfNotFound("User", "/users", "用户资源");
        createResourceIfNotFound("Role", "/roles", "角色资源");
        createResourceIfNotFound("Resource", "/resources", "资源列表");
        createResourceIfNotFound("Privilege", "/privileges", "权限");
        createResourceIfNotFound("Group", "/groups", "用户组");

        logger.info("创建有指定角色的用户");
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        User user = new User();
        user.setPassword("123456");
        user.setUsername("q31514266");
        user.setEmail("developerworks@163.com");
        Set<Role> roles = new HashSet<Role>(Arrays.asList(adminRole));
//        Set<Role> roles = new HashSet<Role>();
//        roles.add(adminRole);
        user.setRoles(roles);
        user.setEnabled(true);
        userRepository.save(user);
        alreadySetup = true;

    }

    @Transactional
    protected Operation createOperationIfNotFound(String name, String description) {

        Operation operation = operationRepository.findByName(name);
        if (operation == null) {
            operation = new Operation(name, description);
            operationRepository.save(operation);
        }
        return operation;
    }

    @Transactional
    protected Role createRoleIfNotFound(String name, Set<Permission> permissions) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPermissions(permissions);
            roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    protected Resource createResourceIfNotFound(String name, String url, String description) {
        Resource resource = resourceRepository.findByName(name);
        if (resource == null) {
            resource = new Resource(name, url, description);
            resourceRepository.save(resource);
        }
        return resource;
    }

    @Transactional
    protected Permission createPermissionIfNotFound(String name, Integer resourceId, Integer operationId) {
        Permission permission = permissionRepository.findByResourceIdAndOperationId(resourceId, operationId);
        if (permission == null) {
            permission = new Permission(name, resourceId, operationId);
            permissionRepository.save(permission);
        }
        return permission;
    }
}
