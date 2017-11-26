package cn.totorotec.repository;

import cn.totorotec.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, String> {
}
