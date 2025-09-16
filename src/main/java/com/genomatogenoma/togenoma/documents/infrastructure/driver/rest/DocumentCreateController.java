package com.genomatogenoma.togenoma.documents.infrastructure.driver.rest;

import com.genomatogenoma.togenoma.documents.application.useCases.CreateDocumentUseCases;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/documents")
public class DocumentCreateController {
    private final CreateDocumentUseCases createDocumentUseCases;

    public DocumentCreateController(CreateDocumentUseCases createDocumentUseCases) {
        this.createDocumentUseCases = createDocumentUseCases;
    }

    @PostMapping
    public ResponseEntity<String> createDocument(@RequestBody DocumentEntities documentEntities) throws Exception {
        if(documentEntities != null){
             Optional<DocumentEntities> documentId = createDocumentUseCases.create(documentEntities);
            return ResponseEntity.ok("The document has been created with name: " + documentId.get().getNameDocument());
        } else {
            return ResponseEntity.badRequest().body("Null data is not allowed to create the document record.");
        }
    }
}
