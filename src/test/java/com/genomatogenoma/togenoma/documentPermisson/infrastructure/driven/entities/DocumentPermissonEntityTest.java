package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.entities;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.domain.enums.PersonType;
import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.documentPermisson.domain.enums.PermissonType;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.entities.DocumentEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class DocumentPermissonEntityTest {

    @Test
    void testNoArgsConstructorAndSetterAndGetters(){
        LocalDateTime now = LocalDateTime.now();

        DocumentEntity expectedDocument = toDomainDocument();
        CompanyEntity expectedCompany = toDomainCompany();

        DocumentPermissonEntity documentPermissonEntities = new DocumentPermissonEntity();
        documentPermissonEntities.setId(1L);
        documentPermissonEntities.setDocumentEntities(expectedDocument);
        documentPermissonEntities.setCompanyEntities(expectedCompany);
        documentPermissonEntities.setPermissonType(PermissonType.READING);
        documentPermissonEntities.setDateGranted(now);

        assertEquals(1L, documentPermissonEntities.getId());

        assertSame(expectedDocument, documentPermissonEntities.getDocumentEntities());
        assertSame(expectedCompany, documentPermissonEntities.getCompanyEntities());

        assertEquals(expectedDocument.getId(), documentPermissonEntities.getDocumentEntities().getId());
        assertEquals(expectedCompany.getId(), documentPermissonEntities.getCompanyEntities().getId());
        assertEquals(PermissonType.READING, documentPermissonEntities.getPermissonType());
        assertEquals(now, documentPermissonEntities.getDateGranted());
    }

    /*@Test
    void testAllArgsConstructor(){
        LocalDateTime now = LocalDateTime.now();
        DocumentPermissonEntity documentPermissonEntity = new DocumentPermissonEntity(
                2L, toDomainDocument(), toDomainCompany(), PermissonType.WRITING, now
        );
    }*/


    private CompanyEntity toDomainCompany(){
        CompanyEntity company = new CompanyEntity();
        company.setId(1L);
        company.setNameCompany("TechCorp");
        company.setNit("123456789");
        company.setDv("1");
        company.setLegalName("TechCorp S.A.");
        company.setTradeName("Tech Corporation");
        company.setPersonType(PersonType.JURIDICA);
        company.setCiiuCode("6201");
        company.setTaxRegime("General");
        company.setIncorporationDate(LocalDate.of(2020, 1, 1));
        company.setChamberRegistration("AB123");
        company.setLegalRepresentative("John Doe");
        company.setLegalRepresentativeId("987654321");
        company.setRutStatus("Activo");
        company.setEmail("contact@techcorp.com");
        company.setPhone("1234567890");
        company.setWebsite("www.techcorp.com");
        company.setAddress("123 Main St");
        company.setActive(true);
        return company;
    }

    private DocumentEntity toDomainDocument(){
        DocumentEntity documentEntities = new DocumentEntity();
        documentEntities.setId(1L);
        documentEntities.setNameDocument("Examen");
        documentEntities.setTypeDocument("PDF");
        documentEntities.setCompanyEntities(toDomainCompany());
        documentEntities.setStorageRoute("/src/resource");
        return documentEntities;
    }
}
