package com.genomatogenoma.togenoma.documents.infrastructure.driven.mappers;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.entities.DocumentEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DocumentMapperTest {
    @Test
    void testEntityToDomain(){
        CompanyEntity entities = companyEntityDB();
        DocumentEntity documentEntity = DocumentEntity.builder()
                .id(1L)
                .nameDocument("Test Document")
                .typeDocument("PDF")
                .companyEntities(entities)
                .storageRoute("/storage/test.pdf")
                .build();

        DocumentEntities entity = DocumentMapper.INSTANCE.DOCUMENT_ENTITIES(documentEntity);

        assertNotNull(entity);
        assertEquals(entity.getId(), documentEntity.getId());
        assertEquals(entity.getNameDocument(), documentEntity.getNameDocument());
        assertEquals(entity.getTypeDocument(), documentEntity.getTypeDocument());
        assertEquals(entity.getStorageRoute(), documentEntity.getStorageRoute());
        assertEquals(entity.getCompanyEntities().getId(), documentEntity.getCompanyEntities().getId());
        
    }


    @Test
    void testDomainToEntity() {
        CompanyEntities companyEntity = companyEntity();
        DocumentEntities documentEntities = DocumentEntities.builder()
                .id(1L)
                .nameDocument("Test Document")
                .typeDocument("PDF")
                .companyEntities(companyEntity)
                .storageRoute("/storage/test.pdf")
                .build();

        DocumentEntity entity = DocumentMapper.INSTANCE.DOCUMENT_ENTITY(documentEntities);

        assertNotNull(entity);
        assertEquals(entity.getId(), documentEntities.getId());
        assertEquals(entity.getNameDocument(), documentEntities.getNameDocument());
        assertEquals(entity.getTypeDocument(), documentEntities.getTypeDocument());
        assertEquals(entity.getStorageRoute(), documentEntities.getStorageRoute());
        assertEquals(entity.getCompanyEntities().getId(), documentEntities.getCompanyEntities().getId());
    }



    private CompanyEntities companyEntity(){
        return CompanyEntities.builder()
                .id(1L)
                .nameCompany("Test Company")
                .nit("123456789")
                .address("123 Test St")
                .phone("555-1234")
                .build();
    }

    private CompanyEntity companyEntityDB(){
        return CompanyEntity.builder()
                .id(1L)
                .nameCompany("Test Company")
                .nit("123456789")
                .address("123 Test St")
                .phone("555-1234")
                .build();
    }
}
