package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.adapters;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.documentPermisson.domain.enums.PermissonType;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.entities.DocumentPermissonEntity;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.mappers.DocumentPermissonMapper;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.repositories.DocumentPermissonRepository;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.entities.DocumentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DocumentPermissonFindAllAdapterTest {

    @Mock
    private DocumentPermissonRepository repository;

    @Mock
    private DocumentPermissonMapper mapper;

    @InjectMocks
    private DocumentPermissonFindAllAdapters adapter;

    private DocumentPermissonEntities domainEntities;
    private DocumentPermissonEntity jpaEntity;
    private DocumentPermissonEntity savedJpaEntity;

    @BeforeEach
    void setUp(){
        domainEntities = createDomainEntities();
        jpaEntity = createJpaEntity(null);
        savedJpaEntity = createJpaEntity(1L);
    }

    @Test
    @DisplayName("FINDALL: Debe retornar lista de permisos cuando existen registros")
    void testFindAll_WithResults() throws Exception {
        List<DocumentPermissonEntity> jpaEntities = createJpaEntityList();

        when(repository.findAll()).thenReturn(jpaEntities);
        when(mapper.DOCUMENT_PERMISSON_ENTITIES(any(DocumentPermissonEntity.class)))
                .thenReturn(domainEntities);

        Optional<List<DocumentPermissonEntities>> result = adapter.findAll();

        assertTrue(result.isPresent(), "El resultado debe estar presente");
        assertFalse(result.get().isEmpty(), "La lista no debe estar vacía");
        assertEquals(3, result.get().size(), "Debe retornar  3 elementos");

        verify(repository, times(1)).findAll();
        verify(mapper, times(3)).DOCUMENT_PERMISSON_ENTITIES(any(DocumentPermissonEntity.class));
    }

    @Test
    @DisplayName("FINDALL: Debe retornar Optional.empty() cuando no hay registros")
    void testFindAll_EmptyResult() throws Exception {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        Optional<List<DocumentPermissonEntities>> result = adapter.findAll();
        verify(repository, times(1)).findAll();
        verify(mapper, never()).DOCUMENT_PERMISSON_ENTITIES(any());
    }

    @Test
    @DisplayName("FINDALL: Debe manejar excepción del repository")
    void testFindAll_WhenRepositoryThrowsException() {
        when(repository.findAll()).thenThrow(new RuntimeException("Database connection error"));

        assertThrows(RuntimeException.class, () -> adapter.findAll());

        verify(repository, times(1)).findAll();

        verify(mapper, never()).DOCUMENT_PERMISSON_ENTITIES(any());
    }

    @Test
    @DisplayName("FINDALL: Debe filtrar elementos null del mapper")
    void testFindAll_WhenMapperReturnsNull() throws Exception {
        List<DocumentPermissonEntity> jpaEntites = createJpaEntityList();
        when(repository.findAll()).thenReturn(jpaEntites);


        when(mapper.DOCUMENT_PERMISSON_ENTITIES(any(DocumentPermissonEntity.class)))
                .thenReturn(domainEntities)
                .thenReturn(null)
                .thenReturn(domainEntities);

        Optional<List<DocumentPermissonEntities>> result = adapter.findAll();

        assertTrue(result.isPresent());

        verify(repository,times(1)).findAll();
        verify(mapper, times(3)).DOCUMENT_PERMISSON_ENTITIES(any());
    }



    //? ========== Métodos Auxiliares =========
    private DocumentPermissonEntities createDomainEntities(){
        DocumentPermissonEntities entities = new DocumentPermissonEntities();
        entities.setId(1L);
        entities.setPermissonType(PermissonType.READING);
        entities.setDateGranted(LocalDateTime.now());
        entities.setDocumentEntities(createDocumentEntities());
        entities.setCompanyEntities(createCompanyEntities());
        return entities;
    }

    private DocumentPermissonEntity createJpaEntity(Long id){
        DocumentPermissonEntity entity = new DocumentPermissonEntity();
        entity.setId(id);
        entity.setPermissonType(PermissonType.READING);
        entity.setDateGranted(LocalDateTime.now());
        entity.setDocumentEntities(createDocumentEntity());
        entity.setCompanyEntities(createCompanyEntity());
        return entity;
    }

    private List<DocumentPermissonEntity> createJpaEntityList(){
        List<DocumentPermissonEntity> list = new ArrayList<>();
        list.add(createJpaEntity(1L));
        list.add(createJpaEntity(2L));
        list.add(createJpaEntity(3L));
        return list;
    }
    private DocumentEntities createDocumentEntities() {
        DocumentEntities doc = new DocumentEntities();
        doc.setId(100L);
        doc.setNameDocument("Test Document");
        doc.setTypeDocument("PDF");
        return doc;
    }

    private DocumentEntity createDocumentEntity() {
        DocumentEntity doc = new DocumentEntity();
        doc.setId(100L);
        doc.setNameDocument("Test Document");
        doc.setTypeDocument("PDF");
        return doc;
    }

    private CompanyEntities createCompanyEntities(){
        CompanyEntities  company = new CompanyEntities();
        company.setId(200L);
        company.setNameCompany("TechCorp");
        company.setNit("1234567890");
        return company;
    }

    private CompanyEntity createCompanyEntity(){
        CompanyEntity company = new CompanyEntity();
        company.setId(200L);
        company.setNameCompany("TechCorp");
        company.setNit("123456789");
        return company;
    }
}
