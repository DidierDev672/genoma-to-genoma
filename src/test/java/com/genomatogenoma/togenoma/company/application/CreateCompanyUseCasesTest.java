package com.genomatogenoma.togenoma.company.application;

import com.genomatogenoma.togenoma.company.application.useCases.CompanyCreateUseCases;
import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.shared.CreateGeneric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CreateCompanyUseCasesTest {
    private CreateGeneric<CompanyEntities> entitiesCreateGeneric;
    private CompanyCreateUseCases companyCreateUseCases;

    @BeforeEach
    void setUp(){
        entitiesCreateGeneric = Mockito.mock(CreateGeneric.class);
        companyCreateUseCases = new CompanyCreateUseCases(entitiesCreateGeneric);
    }

    @Test
    void testCreateReturnCreatedCompany() throws Exception {
        CompanyEntities company = CompanyEntities.builder().id(1L).build();
        when(entitiesCreateGeneric.create(any())).thenReturn(Optional.of(company));

        Optional<CompanyEntities> result = companyCreateUseCases.create(company);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(entitiesCreateGeneric, times(1)).create(company);
    }
}