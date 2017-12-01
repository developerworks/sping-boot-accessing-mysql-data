package cn.totorotec.repository;

import cn.totorotec.entity.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {
    Permission findById(Integer id);

    Permission findByResourceIdAndOperationId(Integer resource_id, Integer permission_id);
}
