package com.genomatogenoma.togenoma.document.application.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.genomatogenoma.togenoma.document.application.port.DocumentPort;
import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;
import com.genomatogenoma.togenoma.document.domain.repositories.DocumentRepository;
import com.genomatogenoma.togenoma.document.infrastructure.driven.mappers.DocumentMapper;
import com.genomatogenoma.togenoma.utils.sanitizer.StringSanitizer;

@Service
public class DocumentUseCases implements DocumentRepository<DocumentEntity, Long> {
    private final DocumentPort documentPort;
    private final StringSanitizer sanitizer;

    public DocumentUseCases(DocumentPort documentPort, StringSanitizer sanitizer) {
        this.documentPort = documentPort;
        this.sanitizer = sanitizer;
    }


    @Override
    public Optional<DocumentEntity> create(DocumentEntity create) throws Exception {
        DocumentEntity documentEntity = this.toMapEntity(create);
        this.documentPort.save(documentEntity);
        return Optional.ofNullable(documentEntity);
    }

    @Override
    public Optional<List<DocumentEntity>> all() throws Exception {
        Optional<List<DocumentEntity>> listDocuments = Optional.ofNullable(this.tDocumentEntities(
                this.documentPort.findAll()));
        return listDocuments;
    }

    @Override
    public Optional<DocumentEntity> findById(Long id) throws Exception {
        Optional<DocumentEntity> documentEntity = this.documentPort.findById(id);
        return documentEntity;
    }

    private List<DocumentEntity> tDocumentEntities(List<DocumentEntity> documentEntities) {
        List<DocumentEntity> documentEntities2 = new ArrayList<>();
        documentEntities.forEach((item) -> {
            documentEntities2.add(this.toMapEntity(item));
        });
        return documentEntities2;
    }

    private DocumentEntity toMapEntity(DocumentEntity documentEntity) {
        return new DocumentEntity(
                documentEntity.getId(),
                sanitizer.sanitize(documentEntity.getTitle()),
                sanitizer.sanitize(documentEntity.getType()),
                sanitizer.sanitize(documentEntity.getStoragePath()),
                documentEntity.getOwnerCompany());
    }

}
