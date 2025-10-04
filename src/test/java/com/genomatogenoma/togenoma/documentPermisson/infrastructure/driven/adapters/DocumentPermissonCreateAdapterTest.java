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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 * ? Test unitario para DocumentPermissionCreateAdapter
 * ?
 * ? IMPORTANTE: Este es un test UNITARIO, por la tanto:
 * ? - No usa la base de datos real (se mockea el repository)
 * ? - No usa Spring Context (@SpringBootTest)
 * ? - Solo prueba la lógica del adaptador
 */

@ExtendWith(MockitoExtension.class)
public class DocumentPermissonCreateAdapterTest {
    @Mock
    private DocumentPermissonRepository repository;

    @Mock
    private DocumentPermissonMapper mapper;

    @InjectMocks
    private DocumentPermissonCreateAdapters documentPermissonCreateAdapters;

    private DocumentPermissonEntities domainEntities;
    private DocumentPermissonEntity jpaEntity;
    private DocumentPermissonEntity savedJpaEntity;

    @BeforeEach
    void setUp(){
        domainEntities = createDomainEntities();
        jpaEntity = createJpaEntity(null); //? Sin ID (antes de guardar)
        savedJpaEntity = createJpaEntity(1L); //? Con ID (Después de guardar)
    }

    @Test
    @DisplayName("CRETE: Debe crear un permiso de documento exitosamente")
    void testCreate_Success() throws Exception {
        //! Arrange - Configurar el comportamiento de los mocks
        when(mapper.DOCUMENT_PERMISSON_ENTITY(domainEntities)).thenReturn(jpaEntity);
        when(repository.save(jpaEntity)).thenReturn(savedJpaEntity);
        when(mapper.DOCUMENT_PERMISSON_ENTITIES(savedJpaEntity)).thenReturn(domainEntities);

        //! Act - Ejecutar el método a probar
        Optional<DocumentPermissonEntities> result = documentPermissonCreateAdapters.create(domainEntities);

        //! Assert - Verificar los resultados
        assertNotNull(result.get(), "The result must not be null");
        assertEquals(domainEntities.getId(), result.get().getId());
        assertEquals(domainEntities.getPermissonType(), result.get().getPermissonType());
        assertEquals(domainEntities.getCompanyEntities().getId(), result.get().getCompanyEntities().getId());
        assertEquals(domainEntities.getDocumentEntities().getId(), result.get().getDocumentEntities().getId());
        assertEquals(domainEntities.getDateGranted(), result.get().getDateGranted());

        //! Verificar que se llamaron los métodos correctos en el orden correctos
        verify(mapper, times(1)).DOCUMENT_PERMISSON_ENTITY(domainEntities);
        verify(repository, times(1)).save(jpaEntity);
        verify(mapper, times(1)).DOCUMENT_PERMISSON_ENTITIES(savedJpaEntity);

        //! Verificar que no  hubo más interacciones
        verifyNoMoreInteractions(mapper, repository);
    }

    @Test
    @DisplayName("CREATE: Debe propagar exception del repository")
    void testCreate_WhenRepositoryThrowsException() {
        when(mapper.DOCUMENT_PERMISSON_ENTITY(domainEntities)).thenReturn(jpaEntity);

        when(repository.save(jpaEntity))
                .thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> documentPermissonCreateAdapters.create(domainEntities));

        verify(mapper, times(1)).DOCUMENT_PERMISSON_ENTITY(domainEntities);
        verify(repository, times(1)).save(jpaEntity);
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
