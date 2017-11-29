package cn.totorotec.service.db;

import java.util.List;

public interface AbstractEntityService<T, TD> {
    T save(T entity);
    T update(T entity);
    void delete(TD id);

    T findById(TD id);
    List<T> findAll();
}
