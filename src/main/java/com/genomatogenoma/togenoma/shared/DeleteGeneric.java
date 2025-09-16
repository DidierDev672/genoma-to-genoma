package com.genomatogenoma.togenoma.shared;

import java.util.Optional;

public interface DeleteGeneric <T, R>{
    Optional<T> delete(R id) throws Exception;
}
