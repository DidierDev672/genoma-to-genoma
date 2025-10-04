package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.adapters;

import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.entities.DocumentPermissonEntity;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.mappers.DocumentPermissonMapper;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.repositories.DocumentPermissonRepository;
import com.genomatogenoma.togenoma.shared.CreateGeneric;

import java.util.Optional;

public class DocumentPermissonCreateAdapters implements CreateGeneric<DocumentPermissonEntities> {
    private final DocumentPermissonRepository documentPermissonRepository;

    private final DocumentPermissonMapper documentPermissonMapper;

    public DocumentPermissonCreateAdapters(DocumentPermissonRepository documentPermissonRepository, DocumentPermissonMapper documentPermissonMapper){
        this.documentPermissonRepository = documentPermissonRepository;
        this.documentPermissonMapper = documentPermissonMapper;
    }
    @Override
    public Optional<DocumentPermissonEntities> create(DocumentPermissonEntities entity) throws Exception {
        if(entity != null){
            DocumentPermissonEntity documentPermisson = documentPermissonMapper.DOCUMENT_PERMISSON_ENTITY(entity);
            DocumentPermissonEntity createdPermisson = documentPermissonRepository.save(documentPermisson);
            return Optional.ofNullable(documentPermissonMapper.DOCUMENT_PERMISSON_ENTITIES(createdPermisson));
        }
        return Optional.empty();
    }
}
