package com.genomatogenoma.togenoma.documents.application.useCases;

import com.genomatogenoma.togenoma.documents.application.ports.FindAllDocumentPort;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;

import java.util.List;
import java.util.Optional;

public class FindAllDocumentUseCases implements FindAllDocumentPort {
    private final FindAllGeneric<DocumentEntities> findAllGeneric;

    public FindAllDocumentUseCases(FindAllGeneric<DocumentEntities> findAllGeneric){
        this.findAllGeneric = findAllGeneric;
    }
    @Override
    public Optional<List<DocumentEntities>> findAll() throws Exception {
        return findAllGeneric.findAll();
    }
}
