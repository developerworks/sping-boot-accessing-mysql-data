package cn.totorotec.repository;

import cn.totorotec.entity.Privilege;
import org.springframework.data.repository.CrudRepository;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

    Privilege findByName(String name);
}
