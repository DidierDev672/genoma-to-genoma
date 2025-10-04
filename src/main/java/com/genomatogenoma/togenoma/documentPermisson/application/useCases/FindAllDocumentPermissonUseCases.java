package com.genomatogenoma.togenoma.documentPermisson.application.useCases;

import com.genomatogenoma.togenoma.documentPermisson.application.ports.FindAllDocumentPermissonPort;
import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;

import java.util.List;
import java.util.Optional;

public class FindAllDocumentPermissonUseCases implements FindAllDocumentPermissonPort {

    private final FindAllGeneric<DocumentPermissonEntities> findAllGeneric;

    public FindAllDocumentPermissonUseCases(FindAllGeneric<DocumentPermissonEntities> findAllGeneric){
        this.findAllGeneric = findAllGeneric;
    }

    @Override
    public Optional<List<DocumentPermissonEntities>> findAll() throws Exception {
        return findAllGeneric.findAll();
    }
}
