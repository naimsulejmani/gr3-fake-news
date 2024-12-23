package dev.naimsulejmani.gr3fakenews;

import java.util.List;

public interface BaseService<T, TId> {
    List<T> findAll();

    T findById(TId id);

    T add(T entity);

    T modify(TId id, T entity);

    void removeById(TId id);
}
