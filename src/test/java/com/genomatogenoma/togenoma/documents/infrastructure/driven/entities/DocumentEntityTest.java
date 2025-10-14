package com.genomatogenoma.togenoma.documents.infrastructure.driven.entities;


import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentEntityTest {
    @Test
    void testDocumentEntitySettersAndGetters(){
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setId(1L);
        documentEntity.setNameDocument("Passport");

        documentEntity.setCompanyEntities(companyEntity());

        assertEquals(1L, documentEntity.getId());
        assertEquals("Passport", documentEntity.getNameDocument());
        assertEquals("Genoma", documentEntity.getCompanyEntities().getNameCompany());


    }
    private CompanyEntity companyEntity(){
        return CompanyEntity.builder()
                .id(1L)
                .nameCompany("Genoma")
                .active(true)
                .build();
    }
}
