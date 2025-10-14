package com.genomatogenoma.togenoma.documents.application;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.documents.application.useCases.CreateDocumentUseCases;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.shared.CreateGeneric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DocumentCreateAdaptersTest {
    private CreateGeneric<DocumentEntities> entitiesCreateGeneric;
    private CreateDocumentUseCases createDocumentPermissonUseCases;

    @BeforeEach
    void setUp(){
        entitiesCreateGeneric = Mockito.mock(CreateGeneric.class);
        createDocumentPermissonUseCases = new CreateDocumentUseCases(entitiesCreateGeneric);
    }

    @Test
    void testCreateReturnCreatedCompany() throws Exception {
        DocumentEntities documentEntities = new DocumentEntities();
        documentEntities.setId(1l);
        documentEntities.setNameDocument("Document 1");
        documentEntities.setStorageRoute("http://example.com/document1");
        documentEntities.setCompanyEntities(this.companyEntities());

        Mockito.when(entitiesCreateGeneric.create(documentEntities)).thenReturn(java.util.Optional.of(documentEntities));

        Optional<DocumentEntities> result = createDocumentPermissonUseCases.create(documentEntities);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        assertEquals("Document 1", result.get().getNameDocument());
        assertEquals("http://example.com/document1", result.get().getStorageRoute());
        assertEquals("Company 1", result.get().getCompanyEntities().getNameCompany());
        verify(entitiesCreateGeneric, times(1)).create(documentEntities);

    }


    private CompanyEntities  companyEntities(){
        CompanyEntities entities = new CompanyEntities();
        entities.setId(1L);
        entities.setNameCompany("Company 1");
        entities.setDv("1");
        entities.setNit("123456789");
        entities.setLegalName("Legal Name 1");
        entities.setTradeName("Trade Name 1");
        entities.setPersonType(com.genomatogenoma.togenoma.company.domain.enums.PersonType.JURIDICA);
        entities.setCiiuCode("A123");
        entities.setTaxRegime("General");
        entities.setIncorporationDate(java.time.LocalDate.now());
        entities.setChamberRegistration("Reg123");
        entities.setLegalRepresentative("Legal Rep 1");
        entities.setLegalRepresentativeId("987654321");
        entities.setRutStatus("Active");
        entities.setEmail("tecnologia@example.com");
        return entities;
    }
}
