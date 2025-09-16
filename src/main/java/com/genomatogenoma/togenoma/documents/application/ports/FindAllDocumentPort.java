package com.genomatogenoma.togenoma.documents.application.ports;

import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;

import java.util.List;
import java.util.Optional;

public interface FindAllDocumentPort {
    Optional<List<DocumentEntities>> findAll() throws Exception;
}
