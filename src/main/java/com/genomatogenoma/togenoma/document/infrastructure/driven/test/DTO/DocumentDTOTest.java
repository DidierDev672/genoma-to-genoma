package com.genomatogenoma.togenoma.document.infrastructure.driven.test.DTO;

import com.genomatogenoma.togenoma.basicCompanyData.domain.entities.CompanyEntity;
import com.genomatogenoma.togenoma.document.infrastructure.driven.DTO.DocumentDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentDTOTest {
    @Test
    public void testDocumentDTO() {
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setId(1L);
        documentDTO.setTitle("Test Document");
        documentDTO.setType("PDF");
        documentDTO.setStoragePath("/path/to/document.pdf");

        CompanyEntity entity = new CompanyEntity();
        entity.setId(100L);
        entity.setCompanyName("Test Company");
        entity.setNit("123456789");
        entity.setPhone("123-456-7890");
        entity.setAddress("123 Test St");
        entity.setDateIncorporation(LocalDate.now());
        entity.setLegalRepresentative("John Doe");
        entity.setState(CompanyEntity.StateCompany.ACTIVE);
        documentDTO.setOwnerCompany(entity);

        assertEquals(1L, documentDTO.getId());
        assertEquals("Test Document", documentDTO.getTitle());
        assertEquals("PDF", documentDTO.getType());
        assertEquals("/path/to/document.pdf", documentDTO.getStoragePath());
        assertEquals(entity, documentDTO.getOwnerCompany());
    }
}
