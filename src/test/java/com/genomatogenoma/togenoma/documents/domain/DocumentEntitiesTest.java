package com.genomatogenoma.togenoma.documents.domain;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentEntitiesTest {
    @Test
    void testNoArgsConstructorAndSetterAndGetters() {
        DocumentEntities documentEntities = new DocumentEntities();
        CompanyEntities companyEntities = new CompanyEntities();

        companyEntities.setId(1L);
        companyEntities.setNameCompany("Test Company");
        companyEntities.setNit("123456789");

        documentEntities.setId(1L);
        documentEntities.setNameDocument("Test Document");
        documentEntities.setCompanyEntities(companyEntities);
        documentEntities.setTypeDocument("PDF");

        assertEquals(1L, documentEntities.getId());
        assertEquals("Test Document", documentEntities.getNameDocument());
        assertEquals(companyEntities, documentEntities.getCompanyEntities());
        assertEquals("PDF", documentEntities.getTypeDocument());
    }

    @Test
    void testAllArgsConstructor(){
        CompanyEntities companyEntities = createCompanyEntities();
        DocumentEntities documentEntities = new DocumentEntities(1L, "Test Document", "/src/resources/", "PDF", companyEntities);

        assertEquals(1L, documentEntities.getId());
        assertEquals("Test Document", documentEntities.getNameDocument());
        assertEquals(companyEntities, documentEntities.getCompanyEntities());
        assertEquals("PDF", documentEntities.getTypeDocument());
    }

    @Test
    void testBuilder(){
        CompanyEntities companyEntities = createCompanyEntities();
        DocumentEntities documentEntities = DocumentEntities.builder()
                .id(1L)
                .nameDocument("Test Document")
                .storageRoute("/src/resources/")
                .typeDocument("PDF")
                .companyEntities(companyEntities)
                .build();

        assertEquals(1L, documentEntities.getId());
        assertEquals("Test Document", documentEntities.getNameDocument());
        assertEquals(companyEntities, documentEntities.getCompanyEntities());
        assertEquals("PDF", documentEntities.getTypeDocument());
    }

    private CompanyEntities createCompanyEntities() {
        CompanyEntities companyEntities = new CompanyEntities();
        companyEntities.setId(1L);
        companyEntities.setNameCompany("Test Company");
        companyEntities.setNit("123456789");
        return companyEntities;
    }
}
