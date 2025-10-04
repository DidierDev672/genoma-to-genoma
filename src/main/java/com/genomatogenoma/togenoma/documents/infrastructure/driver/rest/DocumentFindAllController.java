package com.genomatogenoma.togenoma.documents.infrastructure.driver.rest;

import com.genomatogenoma.togenoma.documents.application.useCases.FindAllDocumentUseCases;
import com.genomatogenoma.togenoma.utils.response.ApiResponse;
import com.genomatogenoma.togenoma.utils.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documents")
public class DocumentFindAllController {
    private final FindAllDocumentUseCases findAllDocumentUseCases;

    public DocumentFindAllController(FindAllDocumentUseCases findAllDocumentUseCases){
        this.findAllDocumentUseCases = findAllDocumentUseCases;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> findAllDocuments() throws Exception {
        var listedDocuments = findAllDocumentUseCases.findAll();

        if(listedDocuments.isEmpty()){
            return ResponseHandler.error("Documents registered in the system have been found.", HttpStatus.CONFLICT);
        }

        return ResponseHandler.success(listedDocuments, "All documents have been obtained successfully");
    }
}
