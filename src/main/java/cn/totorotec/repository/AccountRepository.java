package cn.totorotec.repository;

import cn.totorotec.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
