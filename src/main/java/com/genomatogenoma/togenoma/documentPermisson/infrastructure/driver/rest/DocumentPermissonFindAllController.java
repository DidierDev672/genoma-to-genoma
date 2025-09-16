package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driver.rest;

import com.genomatogenoma.togenoma.documentPermisson.application.useCases.FindAllDocumentPermissonUseCases;
import com.genomatogenoma.togenoma.utils.response.ApiResponse;
import com.genomatogenoma.togenoma.utils.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/document-permisson")
public class DocumentPermissonFindAllController {
    private final FindAllDocumentPermissonUseCases findAllDocumentPermissonUseCases;

    public DocumentPermissonFindAllController(FindAllDocumentPermissonUseCases findAllDocumentPermissonUseCases){
        this.findAllDocumentPermissonUseCases = findAllDocumentPermissonUseCases;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> findAllDocumentPermisson() throws Exception{
        var listedDocumentPermisson = findAllDocumentPermissonUseCases.findAll();
        if(listedDocumentPermisson.isEmpty()){
            return ResponseHandler.error("No permissions are registered in the document system.", HttpStatus.CONFLICT);
        }
        return ResponseHandler.success(listedDocumentPermisson, "The permission list for the documents han been successfully obtained.");
    }
}
