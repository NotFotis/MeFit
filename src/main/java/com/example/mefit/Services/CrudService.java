package com.example.mefit.Services;

import java.util.Collection;

public interface CrudService <T,ID>{
    T findById(ID id);
    Collection<T> findAll();
    T add(T entity);
    T update(ID id,T entity);
    void deleteById(ID id);
    boolean exists(ID id);

}
