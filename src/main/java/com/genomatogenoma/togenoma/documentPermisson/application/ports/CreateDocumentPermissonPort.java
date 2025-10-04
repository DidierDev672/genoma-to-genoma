package com.genomatogenoma.togenoma.documentPermisson.application.ports;

import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;

import java.util.Optional;

public interface CreateDocumentPermissonPort {
    Optional<DocumentPermissonEntities> permissonCreate(DocumentPermissonEntities documentPermissonEntities) throws Exception;
}
