package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.mappers;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.domain.enums.PersonType;
import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.documentPermisson.domain.enums.PermissonType;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.entities.DocumentPermissonEntity;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.entities.DocumentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ? Test Unitario para DocumentPermisssionMapper
 * ? Prueba la conversión bidireccional entre Entity (JPA) y Entities (Domain)
 */
public class DocumentPermissonMapperTest {
    private DocumentPermissonMapper mapper;

    @BeforeEach
    void setUp(){
        mapper = DocumentPermissonMapper.INSTANCE;
    }

    @Test
    @DisplayName("Debe convertir DocumentPermissionEntity a DocumentPermissionEntities correctamente")
    void testEntityToEntities(){

        //* Arrange - Crear objeto JPA Entity
        LocalDateTime now = LocalDateTime.now();
        DocumentPermissonEntity entity = createDocumentPermissionEntity(now);

        //? Act - Convertir
        DocumentPermissonEntities result = mapper.DOCUMENT_PERMISSON_ENTITIES(entity);

        //? Assert - Verificar que todos los campos se mapearon correctamente
        assertNotNull(result, "The result must not be null");
        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getPermissonType(), result.getPermissonType());
        assertEquals(entity.getDateGranted(), result.getDateGranted());

        //? Verificar Document anidado
        assertNotNull(result.getDocumentEntities());
        assertEquals(entity.getDocumentEntities().getId(), result.getDocumentEntities().getId());

        //? Verificado Company anidado
        assertNotNull(result.getCompanyEntities());
        assertEquals(entity.getCompanyEntities().getId(), result.getCompanyEntities().getId());
    }

    @Test
    @DisplayName("Debe convertir DocumentPermissionEntities a DocumentPermissionEntity correctamente")
    void testEntityToEntity(){
        LocalDateTime now = LocalDateTime.now();
        DocumentPermissonEntities entities = createDocumentPermissionEntities(now);

        DocumentPermissonEntity result = mapper.DOCUMENT_PERMISSON_ENTITY(entities);

        assertNotNull(result, "The result must not be null");
        assertEquals(entities.getId(), result.getId());
        assertEquals(entities.getPermissonType(), result.getPermissonType());
        assertEquals(entities.getDateGranted(), result.getDateGranted());

        assertNotNull(result.getDocumentEntities());
        assertEquals(entities.getDocumentEntities().getId(), result.getDocumentEntities().getId());
        assertEquals(entities.getCompanyEntities().getNameCompany(), result.getCompanyEntities().getNameCompany());
    }

    @Test
    @DisplayName("Debe retornar null cuando el Entity es null")
    void testEntityToEntitiesWithNull(){
        DocumentPermissonEntities result = mapper.DOCUMENT_PERMISSON_ENTITIES(null);
        assertNull(result, "Must return null when input is null");
    }

    @Test
    @DisplayName("Debe realizar conversión didireccional sin pérdida de datos")
    void testBidirectionalConversion(){
        LocalDateTime now = LocalDateTime.now();
        DocumentPermissonEntity originalEntity = createDocumentPermissionEntity(now);

        DocumentPermissonEntities entities = mapper.DOCUMENT_PERMISSON_ENTITIES(originalEntity);
        DocumentPermissonEntity resultEntity = mapper.DOCUMENT_PERMISSON_ENTITY(entities);

        assertNotNull(resultEntity);
        assertEquals(originalEntity.getId(), resultEntity.getId());
        assertEquals(originalEntity.getDateGranted(), resultEntity.getDateGranted());
        assertEquals(originalEntity.getDocumentEntities().getId(), resultEntity.getDocumentEntities().getId());
        assertEquals(originalEntity.getCompanyEntities().getId(), resultEntity.getCompanyEntities().getId());
    }

    @Test
    @DisplayName("Debe manejar objetos anidados null correctamente")
    void testWithNullNestedObjects(){
        DocumentPermissonEntity entity = new DocumentPermissonEntity();
        entity.setId(1L);
        entity.setPermissonType(PermissonType.READING);
        entity.setDateGranted(LocalDateTime.now());
        entity.setDocumentEntities(null);
        entity.setCompanyEntities(null);

        DocumentPermissonEntities result = mapper.DOCUMENT_PERMISSON_ENTITIES(entity);

        assertNotNull(result);
        assertEquals(entity.getId(), result.getId());
        assertNull(result.getDocumentEntities(), "DocumentEntities debe ser null");
        assertNull(result.getCompanyEntities(), "CompanyEntities debe ser null");
    }

    //? ========== Métodos auxiliares ============
    private DocumentPermissonEntities createDocumentPermissionEntities(LocalDateTime dateGranted){
        DocumentPermissonEntities entities = new DocumentPermissonEntities();
        entities.setId(1L);
        entities.setPermissonType(PermissonType.READING);
        entities.setDateGranted(dateGranted);
        entities.setDocumentEntities(createDocumentEntities());
        entities.setCompanyEntities(createCompanyEntities());
        return entities;
    }

    private DocumentPermissonEntity createDocumentPermissionEntity(LocalDateTime dateGrated){
        DocumentPermissonEntity entity = new DocumentPermissonEntity();
        entity.setId(1L);
        entity.setPermissonType(PermissonType.READING);
        entity.setDocumentEntities(createDocumentEntity());
        entity.setCompanyEntities(createCompanyEntity());
        return entity;
    }

    private DocumentEntity createDocumentEntity(){
        DocumentEntity doc = new DocumentEntity();
        doc.setId(100L);
        doc.setNameDocument("Test Document");
        doc.setTypeDocument("PDF");
        doc.setStorageRoute("/src/resources/");
        return doc;
    }

    private DocumentEntities createDocumentEntities(){
        DocumentEntities doc = new DocumentEntities();
        doc.setId(100L);
        doc.setTypeDocument("Test Document");
        doc.setTypeDocument("PDF");
        doc.setStorageRoute("/src/resources/");
        return doc;
    }

    private CompanyEntity createCompanyEntity(){
        CompanyEntity company = new CompanyEntity();
        company.setId(200L);
        company.setNameCompany("TechCorp");
        company.setNit("123456789");
        company.setDv("1");
        company.setLegalName("TechCorp S.A");
        company.setPersonType(PersonType.JURIDICA);
        company.setEmail("contact@techcorp.com");
        company.setActive(true);
        return company;
    }

    private CompanyEntities createCompanyEntities(){
        CompanyEntities company = new CompanyEntities();
        company.setId(20L);
        company.setNameCompany("TechCorp");
        company.setNit("123456789");
        company.setDv("1");
        company.setLegalName("TechCorp S.A");
        company.setPersonType(PersonType.JURIDICA);
        company.setEmail("contact@techcorp.com");
        company.setActive(true);
        return company;
    }
}
