package com.genomatogenoma.togenoma.company.infrastructure.driven.adapters;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import com.genomatogenoma.togenoma.company.infrastructure.driven.mappers.CompanyMapper;
import com.genomatogenoma.togenoma.company.infrastructure.driven.repositories.CompanyJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CompanyCreateAdapterTest {
    private CompanyJpaRepository repository;
    private CompanyMapper mapper;
    private CompanyCreateAdapter adapter;

    @BeforeEach
    void setUp(){
        repository = mock(CompanyJpaRepository.class);
        mapper = mock(CompanyMapper.class);
        adapter = new CompanyCreateAdapter(repository, mapper);
    }

    @Test
    void testCreateReturnsSavedCompanyEntities() throws Exception {
        CompanyEntities domain = CompanyEntities.builder().id(1L).build();
        CompanyEntity entity = CompanyEntity.builder().id(1L).build();

        when(mapper.COMPANY_ENTITY(domain)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.COMPANY_ENTITIES(entity)).thenReturn(domain);

        Optional<CompanyEntities> result = adapter.create(domain);

        assertTrue(result.isPresent());
        assertEquals(domain, result.get());
        verify(mapper).COMPANY_ENTITY(domain);
        verify(repository).save(entity);
        verify(mapper).COMPANY_ENTITIES(entity);
    }
}
