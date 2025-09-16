package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.adapters;

import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.entities.DocumentPermissonEntity;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.mappers.DocumentPermissonMapper;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.repositories.DocumentPermissonRepository;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DocumentPermissonFindAllAdapters implements FindAllGeneric<DocumentPermissonEntities> {
    private final DocumentPermissonRepository documentPermissonRepository;
    private final DocumentPermissonMapper documentPermissonMapper;

    public DocumentPermissonFindAllAdapters(DocumentPermissonRepository documentPermissonRepository, DocumentPermissonMapper documentPermissonMapper){
        this.documentPermissonRepository = documentPermissonRepository;
        this.documentPermissonMapper = documentPermissonMapper;
    }
    @Override
    public Optional<List<DocumentPermissonEntities>> findAll() throws Exception {
        List<DocumentPermissonEntities> documentPermissonEntities = new ArrayList<>();
        List<DocumentPermissonEntity> permissonEntities = documentPermissonRepository.findAll();

        if(permissonEntities.isEmpty()){
            return Optional.empty();
        }

        permissonEntities.forEach((item) -> {
            documentPermissonEntities.add(documentPermissonMapper.DOCUMENT_PERMISSON_ENTITIES(item));
        });

        return Optional.of(documentPermissonEntities);
    }
}
