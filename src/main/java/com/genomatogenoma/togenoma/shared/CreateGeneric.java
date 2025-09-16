package com.genomatogenoma.togenoma.shared;


import java.util.Optional;

public interface CreateGeneric <T>{
    Optional<T> create(T entity) throws Exception;
}
