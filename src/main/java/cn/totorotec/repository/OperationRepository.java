package cn.totorotec.repository;

import cn.totorotec.entity.Operation;
import org.springframework.data.repository.CrudRepository;

public interface OperationRepository extends CrudRepository<Operation, Long> {
    Operation findByName(String name);
}
