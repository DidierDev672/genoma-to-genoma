package com.genomatogenoma.togenoma.company.infrastructure.driver.config;

import com.genomatogenoma.togenoma.company.application.useCases.CompanyCreateUseCases;
import com.genomatogenoma.togenoma.company.application.useCases.FindAllCompanyUseCase;
import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.infrastructure.driven.adapters.CompanyCreateAdapter;
import com.genomatogenoma.togenoma.company.infrastructure.driven.mappers.CompanyMapper;
import com.genomatogenoma.togenoma.company.infrastructure.driven.repositories.CompanyJpaRepository;
import com.genomatogenoma.togenoma.shared.CreateGeneric;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class CompanyConfigTest {
    private final CompanyConfig config = new CompanyConfig();

    @Test
    void testCompanyCreateAdapterBean(){
        CompanyJpaRepository repository = mock(CompanyJpaRepository.class);
        CompanyMapper mapper = mock(CompanyMapper.class);
        CompanyCreateAdapter adapter = config.companyCreateAdapter(repository, mapper);
        assertNotNull(adapter);
    }

    @Test
    void testCompanyCreateUseCasesBean(){
        CreateGeneric<CompanyEntities> createGeneric = mock(CreateGeneric.class);
        CompanyCreateUseCases useCases = config.companyCreateUseCases(createGeneric);
        assertNotNull(useCases);
    }

    @Test
    void testFindAllCompanyUseCaseBeen(){
        FindAllGeneric<CompanyEntities> findAllGeneric = mock(FindAllGeneric.class);
        FindAllCompanyUseCase useCase = config.findAllCompanyUseCase(findAllGeneric);
        assertNotNull(useCase);
    }
}
