package cn.totorotec.repository;

import cn.totorotec.entity.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long> {
    Resource findByName(String name);
    Resource findByUrl(String url);
}
