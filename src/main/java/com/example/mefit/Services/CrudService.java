package com.example.mefit.Services;

import java.util.Collection;

public interface CrudService <T,ID>{

    Collection<T> findAll();
    T add(T entity);
    T findById(ID id);

    T update(ID id, T entity);

    void deleteById(ID id);

    boolean exists(ID id);

}
