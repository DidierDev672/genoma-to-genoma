package com.genomatogenoma.togenoma.shared;


import java.util.List;
import java.util.Optional;

public interface FindAllGeneric<T> {
    Optional<List<T>> findAll() throws Exception;
}
