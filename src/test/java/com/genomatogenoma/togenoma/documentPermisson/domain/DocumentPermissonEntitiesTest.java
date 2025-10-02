package com.genomatogenoma.togenoma.documentPermisson.domain;
import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.domain.enums.PersonType;
import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.documentPermisson.domain.enums.PermissonType;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DocumentPermissonEntitiesTest {

    @Test
    void testNoArgsConstructorAndSettersAndGetters(){
        DocumentPermissonEntities documentPermissonEntities = new DocumentPermissonEntities();
        documentPermissonEntities.setId(1L);
        documentPermissonEntities.setCompanyEntities(toDomainCompany());
        documentPermissonEntities.setDocumentEntities(toDomainDocument());
        documentPermissonEntities.setPermissonType(PermissonType.READING);
        LocalDateTime now = LocalDateTime.now();
        documentPermissonEntities.setDateGranted(now);

        assertEquals(1L, documentPermissonEntities.getId());
        assertEquals(toDomainCompany(), documentPermissonEntities.getCompanyEntities());
        assertEquals(toDomainDocument(), documentPermissonEntities.getDocumentEntities());
        assertEquals(PermissonType.READING, documentPermissonEntities.getPermissonType());
        assertEquals(now, documentPermissonEntities.getDateGranted());
    }


    @Test
    void testAllArgsConstructor(){
        LocalDateTime now = LocalDateTime.now();

        DocumentPermissonEntities permissonEntities = new DocumentPermissonEntities(
                2L, toDomainDocument(), toDomainCompany(), PermissonType.WRITING,
                now
        );

        assertEquals(2L, permissonEntities.getId());
        assertEquals(toDomainDocument(), permissonEntities.getDocumentEntities());
        assertEquals(toDomainCompany(), permissonEntities.getCompanyEntities());
        assertEquals(PermissonType.WRITING, permissonEntities.getPermissonType());
        assertEquals(now, permissonEntities.getDateGranted());
    }

    @Test
    void testBuilder(){
        LocalDateTime now = LocalDateTime.now();
        DocumentPermissonEntities permissonEntities = DocumentPermissonEntities.builder()
                .id(3L)
                .documentEntities(toDomainDocument())
                .companyEntities(toDomainCompany())
                .permissonType(PermissonType.SHARE)
                .dateGranted(now)
                .build();

        assertEquals(3L, permissonEntities.getId());
        assertEquals(toDomainDocument(), permissonEntities.getDocumentEntities());
        assertEquals(toDomainCompany(), permissonEntities.getCompanyEntities());
        assertEquals(PermissonType.SHARE, permissonEntities.getPermissonType());
        assertEquals(now, permissonEntities.getDateGranted());
    }


    private CompanyEntities toDomainCompany() {
        CompanyEntities company = new CompanyEntities();
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

    private DocumentEntities toDomainDocument(){
        DocumentEntities documentEntities = new DocumentEntities();
        documentEntities.setId(1L);
        documentEntities.setNameDocument("1234567890");
        documentEntities.setCompanyEntities(toDomainCompany());
        documentEntities.setTypeDocument("PDF");
        documentEntities.setStorageRoute("/src/resources/");
        return documentEntities;
    }
}
