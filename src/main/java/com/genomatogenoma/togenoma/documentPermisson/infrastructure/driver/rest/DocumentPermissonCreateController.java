package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driver.rest;

import com.genomatogenoma.togenoma.documentPermisson.application.useCases.CreateDocumentPermissonUseCases;
import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/document-permisson")
public class DocumentPermissonCreateController {
    private final CreateDocumentPermissonUseCases createDocumentPermissonUseCases;

    public DocumentPermissonCreateController(CreateDocumentPermissonUseCases createDocumentPermissonUseCases){
        this.createDocumentPermissonUseCases = createDocumentPermissonUseCases;
    }

    @PostMapping
    public ResponseEntity<?> createDocumentPermisson(@RequestBody DocumentPermissonEntities permissonEntities) throws Exception {
        if(permissonEntities != null){
            if(permissonEntities.getCompanyEntities() == null || permissonEntities.getDocumentEntities() == null){
                return new ResponseEntity<>("Do not allow null data. You must review the data entered. Please", HttpStatus.CONFLICT);
            }
            Optional<DocumentPermissonEntities> savedPermisson = createDocumentPermissonUseCases.permissonCreate(permissonEntities);
            if(savedPermisson.isEmpty()){
                return new ResponseEntity<>("The permissions for the document could not be created. You must review the information. Please enter.", HttpStatus.CONFLICT);
            }

            return new ResponseEntity<>("Permissions for the document have been successfully created.", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Do not allow null data. You must review the data entered. Please", HttpStatus.CONFLICT);
    }
}
