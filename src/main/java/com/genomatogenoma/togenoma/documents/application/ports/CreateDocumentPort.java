package com.genomatogenoma.togenoma.documents.application.ports;

import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;

import java.util.Optional;

public interface CreateDocumentPort {
    Optional<DocumentEntities> create( DocumentEntities documentEntities ) throws Exception;
}
