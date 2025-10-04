package com.genomatogenoma.togenoma.documentPermisson.application.ports;

import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;

import java.util.List;
import java.util.Optional;

public interface FindAllDocumentPermissonPort {
    Optional<List<DocumentPermissonEntities>> findAll() throws Exception;
}
