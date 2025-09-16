package com.genomatogenoma.togenoma.company.infrastructure.driven.adapters;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import com.genomatogenoma.togenoma.company.infrastructure.driven.mappers.CompanyMapper;
import com.genomatogenoma.togenoma.company.infrastructure.driven.repositories.CompanyJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompanyFindAllAdapterTest {
    private CompanyJpaRepository repository;
    private CompanyMapper mapper;
    private CompanyFindAllAdapter adapter;

    @BeforeEach
    void setUp(){
        repository = mock(CompanyJpaRepository.class);
        mapper = mock(CompanyMapper.class);
        adapter = new CompanyFindAllAdapter(repository, mapper);
    }

    @Test
    void testFindAllReturnsMappedList() throws Exception {
        CompanyEntity entity1 = CompanyEntity.builder().id(1L).build();
        CompanyEntity entity2 = CompanyEntity.builder().id(2L).build();

        CompanyEntities domain1 = CompanyEntities.builder().id(1L).build();
        CompanyEntities domain2 = CompanyEntities.builder().id(2L).build();

        when(repository.findAll()).thenReturn(Arrays.asList(entity1, entity2));
        when(mapper.COMPANY_ENTITIES(entity1)).thenReturn(domain1);
        when(mapper.COMPANY_ENTITIES(entity2)).thenReturn(domain2);

        Optional<List<CompanyEntities>> result = adapter.findAll();

        assertTrue(result.isPresent());
        assertEquals(2, result.get().size());
        assertEquals(domain1, result.get().get(0));
        assertEquals(domain2, result.get().get(1));
    }

    @Test
    void testFindAllReturnsEmptyWhenEntities() throws Exception {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        Optional<List<CompanyEntities>> result = adapter.findAll();

        assertFalse(result.isPresent());
    }
}
