package com.genomatogenoma.togenoma.documentPermisson.application.useCases;

import com.genomatogenoma.togenoma.documentPermisson.application.ports.CreateDocumentPermissonPort;
import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.shared.CreateGeneric;

import java.util.Optional;

public class CreateDocumentPermissonUseCases implements CreateDocumentPermissonPort {
    private final CreateGeneric<DocumentPermissonEntities> entitiesCreateGeneric;

    public CreateDocumentPermissonUseCases(CreateGeneric<DocumentPermissonEntities> entitiesCreateGeneric){
        this.entitiesCreateGeneric = entitiesCreateGeneric;
    }
    @Override
    public Optional<DocumentPermissonEntities> permissonCreate(DocumentPermissonEntities documentPermissonEntities) throws Exception {
        return this.entitiesCreateGeneric.create(documentPermissonEntities);
    }
}
