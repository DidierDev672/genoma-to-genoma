package com.genomatogenoma.togenoma.document.domain.test;

import com.genomatogenoma.togenoma.basicCompanyData.domain.entities.CompanyEntity;
import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DocumentTest {
    @Test
    public void testIsValidDocumentName() {
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setId(1L);
        documentEntity.setTitle("Test Document");
        documentEntity.setType("PDF");
        documentEntity.setStoragePath("");
        CompanyEntity entity = new CompanyEntity();
        entity.setId(4L);
        entity.setCompanyName("Genoma");
        entity.setNit("123456789");
        entity.setAddress("123 Main St");
        entity.setPhone("555-1234");
        entity.setEmail("example@example.com");
        entity.setLegalRepresentative("John Doe");
        entity.setDateIncorporation(LocalDateTime.now().toLocalDate());
        entity.setState(CompanyEntity.StateCompany.ACTIVE);
        documentEntity.setOwnerCompany(entity);

        assertEquals(1L, documentEntity.getId());
        assertEquals("Test Document", documentEntity.getTitle());
        assertEquals("PDF", documentEntity.getType());
        assertEquals("", documentEntity.getStoragePath());
        assertEquals("Genoma", documentEntity.getOwnerCompany().getCompanyName());
    }
}
