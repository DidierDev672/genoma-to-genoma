package com.genomatogenoma.togenoma.documents.infrastructure.driven.adapters;

import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.entities.DocumentEntity;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.mappers.DocumentMapper;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.repotories.DocumentRepository;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DocumentFindAllAdapters implements FindAllGeneric<DocumentEntities> {
    private final DocumentRepository repository;
    private final DocumentMapper documentMapper;

    public DocumentFindAllAdapters(DocumentRepository repository, DocumentMapper documentMapper){
        this.repository  = repository;
        this.documentMapper = documentMapper;
    }
    @Override
    public Optional<List<DocumentEntities>> findAll() throws Exception {
        List<DocumentEntities> documentEntities = new ArrayList<>();
        List<DocumentEntity> documentEntity = (List<DocumentEntity>) repository.findAll();
        if(documentEntity.isEmpty()){
            return Optional.empty();
        }

        documentEntity.forEach((item) -> {
            documentEntities.add(documentMapper.DOCUMENT_ENTITIES(item));
        });

        return Optional.of(documentEntities);
    }
}
