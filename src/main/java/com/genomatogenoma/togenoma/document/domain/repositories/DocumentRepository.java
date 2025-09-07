package com.genomatogenoma.togenoma.document.domain.repositories;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository<T, R> {
    Optional<T> create(T create) throws Exception;

    Optional<List<T>> all() throws Exception;

    Optional<T> findById(R id) throws Exception;
}
