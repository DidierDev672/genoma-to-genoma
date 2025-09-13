package com.genomatogenoma.togenoma.document.infrastructure.driven.test.mappers;

import com.genomatogenoma.togenoma.basicCompanyData.domain.entities.CompanyEntity;
import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;
import com.genomatogenoma.togenoma.document.infrastructure.driven.DTO.DocumentDTO;
import com.genomatogenoma.togenoma.document.infrastructure.driven.mappers.DocumentMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentMapperTest {
    @Test
    public void testDocumentMapping(){
        DocumentEntity documentEntity = new DocumentEntity();

        documentEntity.setId(1L);
        documentEntity.setTitle("Test Document");
        documentEntity.setType("PDF");
        documentEntity.setStoragePath("/path/to/document.pdf");

        CompanyEntity entity = new CompanyEntity();
        entity.setId(1L);
        entity.setCompanyName("Test Company");
        entity.setEmail("company@example.com");
        entity.setPhone("1234567890");
        entity.setAddress("123 Test St");
        entity.setNit("123456789");
        entity.setLegalRepresentative("John Doe");
        entity.setDateIncorporation(LocalDate.now());
        entity.setState(CompanyEntity.StateCompany.ACTIVE);
        documentEntity.setOwnerCompany(entity);

        documentEntity.setOwnerCompany(null);

        DocumentDTO documentDTO = DocumentMapper.INSTANCE.documentToDocumentDTO(documentEntity);
        assert documentDTO.getId().equals(documentEntity.getId());
        assert documentDTO.getTitle().equals(documentEntity.getTitle());
        assert documentDTO.getType().equals(documentEntity.getType());
        assert documentDTO.getStoragePath().equals(documentEntity.getStoragePath());
        assert Objects.equals(documentDTO.getOwnerCompany(), documentEntity.getOwnerCompany());
    }

    @Test
    public void testDocumentDTOToEntityMapping() {
        DocumentDTO documentDTO = new DocumentDTO();

        documentDTO.setId(1L);
        documentDTO.setTitle("Test Document");
        documentDTO.setType("PDF");
        documentDTO.setStoragePath("/path/to/document.pdf");

        CompanyEntity entity = new CompanyEntity();
        entity.setId(1L);
        entity.setCompanyName("Test Company");
        entity.setEmail("company@example.com");
        entity.setPhone("1234567890");
        entity.setAddress("123 Test St");
        entity.setNit("123456789");
        entity.setLegalRepresentative("John Doe");
        entity.setDateIncorporation(LocalDate.now());
        entity.setState(CompanyEntity.StateCompany.ACTIVE);
        documentDTO.setOwnerCompany(entity);

        DocumentEntity Documententity = DocumentMapper.INSTANCE.documentDTOToDocument(documentDTO);
        assertEquals(documentDTO.getId(), Documententity.getId());
        assertEquals(documentDTO.getTitle(), Documententity.getTitle());
        assertEquals(documentDTO.getType(), Documententity.getType());
        assertEquals(documentDTO.getStoragePath(), Documententity.getStoragePath());
        assertEquals(entity, documentDTO.getOwnerCompany());
    }
}
