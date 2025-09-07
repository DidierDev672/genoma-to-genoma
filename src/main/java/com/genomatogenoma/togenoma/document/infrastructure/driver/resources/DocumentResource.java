package com.genomatogenoma.togenoma.document.infrastructure.driver.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genomatogenoma.togenoma.document.application.useCases.DocumentUseCases;
import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;
import com.genomatogenoma.togenoma.document.infrastructure.driven.DTO.DocumentDTO;
import com.genomatogenoma.togenoma.document.infrastructure.driven.mappers.DocumentMapper;
import com.genomatogenoma.togenoma.utils.response.ApiResponse;
import com.genomatogenoma.togenoma.utils.response.ResponseHandler;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/documents")
public class DocumentResource {
    private final DocumentUseCases documentUseCases;
    private final DocumentMapper documentMapper;

    public DocumentResource(DocumentUseCases documentUseCases, DocumentMapper documentMapper) {
        this.documentUseCases = documentUseCases;
        this.documentMapper = documentMapper;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DocumentDTO>> create(@RequestBody DocumentDTO documentDTO) {
        return ResponseHandler.success(documentDTO, "The document has been created successfully");
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DocumentDTO>>> getMethodName() throws Exception {
        List<DocumentDTO> documentDTOs = new ArrayList<>();
        Optional<List<DocumentEntity>> documentEntity = this.documentUseCases.all();
        if (documentEntity.isPresent()) {
            documentEntity.get().forEach((item) -> {
                DocumentDTO dto = this.documentMapper.documentToDocumentDTO(item);
                documentDTOs.add(dto);
            });
        }
        return ResponseHandler.success(documentDTOs, "All documents have been successfully obtained");
    }
}
