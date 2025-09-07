package com.genomatogenoma.togenoma.document.test.infrastructure.driven.mappers;
import com.genomatogenoma.togenoma.basicCompanyData.domain.entities.CompanyEntity;
import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;
import com.genomatogenoma.togenoma.document.infrastructure.driven.DTO.DocumentDTO;
import com.genomatogenoma.togenoma.document.infrastructure.driven.mappers.DocumentMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentMapperTest {
    @Test
    public void testDocumentToDocumentDTOMapping() {
        DocumentEntity documentEntity = new DocumentEntity();
        CompanyEntity entity = new CompanyEntity();

        //! Setter of the Company Entities.
        entity.setId(4L);
        entity.setCompanyName("");
        entity.setNit("");
        entity.setAddress("");
        entity.setPhone("");
        entity.setEmail("");
        entity.setLegalRepresentative("");
        entity.setDateIncorporation(LocalDate.now());
        entity.setState(CompanyEntity.StateCompany.ACTIVE);

        documentEntity.setId(1L);
        documentEntity.setTitle("Results of medical examinations");
        documentEntity.setType("RESULT");
        documentEntity.setStoragePath("/src/result/exam/medicos/");
        documentEntity.setOwnerCompany(entity);

        //* Map the Document object to DocumentDTO
        DocumentDTO documentDTO = DocumentMapper.INSTANCE.documentToDocumentDTO(documentEntity);

        //TODO: Assert that the mapping is correct
        assertEquals(documentEntity.getId(), documentDTO.getId());
        assertEquals(documentEntity.getTitle(), documentDTO.getTitle());
        assertEquals(documentEntity.getType(), documentDTO.getType());
        assertEquals(documentEntity.getStoragePath(), documentDTO.getStoragePath());
        assertEquals(documentEntity.getOwnerCompany(), documentDTO.getOwnerCompany());
    }

    @Test
    public void testDocumentDTOToDocumentMapping(){
       DocumentDTO documentDTO = new DocumentDTO();
        CompanyEntity entity = new CompanyEntity();

        //! Setter of the Company Entities.
        entity.setId(4L);
        entity.setCompanyName("");
        entity.setNit("");
        entity.setAddress("");
        entity.setPhone("");
        entity.setEmail("");
        entity.setLegalRepresentative("");
        entity.setDateIncorporation(LocalDate.now());
        entity.setState(CompanyEntity.StateCompany.ACTIVE);

       documentDTO.setId(1L);
       documentDTO.setTitle("Results of medical examinations");
       documentDTO.setType("RESULT");
       documentDTO.setStoragePath("/src/result/exam/medicos/");
       documentDTO.setOwnerCompany(entity);

       //* Map the DocumentDTO object to DocumentEntity
       DocumentEntity documentEntity = DocumentMapper.INSTANCE.documentDTOToDocument(documentDTO);

       //TODO: Assert that the mapping is correct
        assertEquals(documentDTO.getId(), documentEntity.getId());
        assertEquals(documentDTO.getTitle(), documentEntity.getTitle());
        assertEquals(documentDTO.getType(), documentEntity.getType());
        assertEquals(documentDTO.getStoragePath(), documentEntity.getStoragePath());
        assertEquals(documentDTO.getOwnerCompany(), documentEntity.getOwnerCompany());
    }
}
