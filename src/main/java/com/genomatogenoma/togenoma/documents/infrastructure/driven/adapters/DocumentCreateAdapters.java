package com.genomatogenoma.togenoma.documents.infrastructure.driven.adapters;

import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.mappers.DocumentMapper;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.repotories.DocumentRepository;
import com.genomatogenoma.togenoma.shared.CreateGeneric;

import java.util.Optional;

public class DocumentCreateAdapters implements CreateGeneric<DocumentEntities> {
    private final DocumentRepository repository;
    private final DocumentMapper documentMapper;

    public DocumentCreateAdapters(DocumentRepository repository, DocumentMapper documentMapper) {
        this.repository = repository;
        this.documentMapper = documentMapper;
    }

    @Override
    public Optional<DocumentEntities> create(DocumentEntities entity) throws Exception {
        if (entity != null) {
            return Optional.ofNullable(
                    documentMapper.DOCUMENT_ENTITIES(
                            repository.save(
                                    documentMapper.DOCUMENT_ENTITY(entity)
                            )
                    )
            );
        }
        return Optional.empty();
    }
}
