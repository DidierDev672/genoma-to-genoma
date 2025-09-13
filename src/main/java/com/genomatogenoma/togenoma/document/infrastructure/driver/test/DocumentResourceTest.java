package com.genomatogenoma.togenoma.document.infrastructure.driver.test;

import com.genomatogenoma.togenoma.basicCompanyData.domain.entities.CompanyEntity;
import com.genomatogenoma.togenoma.document.application.port.DocumentPort;
import com.genomatogenoma.togenoma.document.application.useCases.DocumentUseCases;
import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;
import com.genomatogenoma.togenoma.document.infrastructure.driven.DTO.DocumentDTO;
import com.genomatogenoma.togenoma.document.infrastructure.driven.mappers.DocumentMapper;
import com.genomatogenoma.togenoma.document.infrastructure.driver.resources.DocumentResource;
import com.genomatogenoma.togenoma.utils.response.ApiResponse;
import com.genomatogenoma.togenoma.utils.sanitizer.StringSanitizer;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DocumentResourceTest {

    private DocumentPort documentPort;
    private StringSanitizer stringSanitizer;
    @Test
    public void testCreateDocument() {
        DocumentMapper documentMapper = new DocumentMapper() {
            @Override
            public DocumentDTO documentToDocumentDTO(DocumentEntity entity) {
                DocumentDTO dto = new DocumentDTO();
                dto.setId(entity.getId());
                dto.setTitle(entity.getTitle());
                dto.setType(entity.getType());
                dto.setStoragePath(entity.getStoragePath());
                dto.setOwnerCompany(entity.getOwnerCompany());
                return dto;
            }

            @Override
            public DocumentEntity documentDTOToDocument(DocumentDTO documentDTO) {
                return null;
            }
        };

        DocumentResource documentResource = new DocumentResource(
                new DocumentUseCases(documentPort, stringSanitizer), documentMapper
        ){

        };

        DocumentEntity documentEntity = new DocumentEntity();
        CompanyEntity entity = new CompanyEntity();
        documentEntity.setId(1L);
        documentEntity.setTitle("Test Document");
        documentEntity.setType("PDF");
        documentEntity.setStoragePath("/path/to/document.pdf");

        entity.setId(1L);
        entity.setCompanyName("Test Company");
        entity.setNit("123456789");
        entity.setAddress("123 Test St, Test City, TC 12345");
        entity.setPhone("(12) 3456-7890");
        entity.setEmail("company@gmail.com");
        entity.setLegalRepresentative("John Doe");
        entity.setState(CompanyEntity.StateCompany.ACTIVE);
        documentEntity.setOwnerCompany(entity);
        DocumentDTO documentDTO = documentMapper.documentToDocumentDTO(documentEntity);
        ResponseEntity<ApiResponse<DocumentDTO>> createdDocument = documentResource.create(documentDTO);
        assertTrue(Objects.requireNonNull(createdDocument.getBody()).isSuccess());
        assertEquals("The document has been created successfully", createdDocument.getBody().getMessage());
    }
}
