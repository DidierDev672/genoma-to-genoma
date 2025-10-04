package com.genomatogenoma.togenoma.documents.application.useCases;

import com.genomatogenoma.togenoma.documents.application.ports.CreateDocumentPort;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.shared.CreateGeneric;

import java.util.Optional;

public class CreateDocumentUseCases implements CreateDocumentPort {
    private final CreateGeneric<DocumentEntities> entitiesCreateGeneric;

    public CreateDocumentUseCases(CreateGeneric<DocumentEntities> entitiesCreateGeneric) {
        this.entitiesCreateGeneric = entitiesCreateGeneric;
    }
    @Override
    public Optional<DocumentEntities> create(DocumentEntities documentEntities) throws Exception {
        if ( documentEntities != null ) {
            return entitiesCreateGeneric.create( documentEntities );
        }
        return Optional.empty();
    }
}
