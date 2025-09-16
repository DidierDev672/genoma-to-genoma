package com.genomatogenoma.togenoma.shared;

import java.util.Optional;

public interface FindGeneric <T, R>{
    Optional<T> find(R id) throws Exception;
}
