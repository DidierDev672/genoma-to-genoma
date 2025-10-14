package com.genomatogenoma.togenoma.documents.infrastructure.driver.rest;

import com.genomatogenoma.togenoma.documents.application.useCases.CreateDocumentUseCases;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import org.springframework.http.HttpStatus;
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
        if(documentEntities == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Null data is not allowed to create the document record.");
        }

        return createDocumentUseCases.create(documentEntities)
                .map(saved -> ResponseEntity.ok(
                        String.format("The document has been created with name: %s", saved.getNameDocument())))
                .orElse(ResponseEntity.badRequest().build());
    }
}
