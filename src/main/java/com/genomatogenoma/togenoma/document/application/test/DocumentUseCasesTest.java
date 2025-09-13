package com.genomatogenoma.togenoma.document.application.test;

import com.genomatogenoma.togenoma.basicCompanyData.domain.entities.CompanyEntity;
import com.genomatogenoma.togenoma.document.application.port.DocumentPort;
import com.genomatogenoma.togenoma.document.application.useCases.DocumentUseCases;
import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;
import com.genomatogenoma.togenoma.utils.sanitizer.StringSanitizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DocumentUseCasesTest {
    private DocumentPort documentPort;
    private StringSanitizer sanitizer;

    @BeforeEach
    public void setUp(){
        documentPort = new DocumentPort() {
            @Override
            public List<DocumentEntity> findAll(Sort sort) {
                return List.of();
            }

            @Override
            public Page<DocumentEntity> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends DocumentEntity> S save(S entity) {
                return null;
            }

            @Override
            public <S extends DocumentEntity> List<S> saveAll(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public Optional<DocumentEntity> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public List<DocumentEntity> findAll() {
                return List.of();
            }

            @Override
            public List<DocumentEntity> findAllById(Iterable<Long> longs) {
                return List.of();
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(DocumentEntity entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends DocumentEntity> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends DocumentEntity> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends DocumentEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public void deleteAllInBatch(Iterable<DocumentEntity> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public DocumentEntity getOne(Long aLong) {
                return null;
            }

            @Override
            public DocumentEntity getById(Long aLong) {
                return null;
            }

            @Override
            public DocumentEntity getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends DocumentEntity> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends DocumentEntity> List<S> findAll(Example<S> example) {
                return List.of();
            }

            @Override
            public <S extends DocumentEntity> List<S> findAll(Example<S> example, Sort sort) {
                return List.of();
            }

            @Override
            public <S extends DocumentEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends DocumentEntity> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends DocumentEntity> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends DocumentEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
        sanitizer = new StringSanitizer();
    }
    @Test
    public void shouldCreatedDocument() {
        DocumentUseCases documentUseCases = new DocumentUseCases(documentPort, sanitizer);

        CompanyEntity entity = new CompanyEntity();
        entity.setId(1L);
        entity.setCompanyName("Test Company");
        entity.setAddress("123 Test St");
        entity.setNit("123456789");
        entity.setPhone("555-1234");
        entity.setEmail("example@example.com");
        entity.setLegalRepresentative("John Doe");
        entity.setDateIncorporation(LocalDate.now());
        entity.setState(CompanyEntity.StateCompany.ACTIVE);

        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setId(1L);
        documentEntity.setTitle("Title1");
        documentEntity.setType("Type1");
        documentEntity.setStoragePath("/path/to/doc1");
        documentEntity.setOwnerCompany(entity);
        try {
            Optional<DocumentEntity> documentEntity1 = documentUseCases.create(documentEntity);
            assertTrue(documentEntity1.isPresent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void shouldListAllDocuments() {
        DocumentUseCases documentUseCases = new DocumentUseCases(documentPort, sanitizer);
        try {
            Optional<List<DocumentEntity>> listDocuments = documentUseCases.all();
            assertTrue(listDocuments.isPresent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void shouldFindDocumentById() {
        DocumentUseCases documentUseCases = new DocumentUseCases(documentPort, sanitizer);
        try {
            Optional<DocumentEntity> documentEntity = documentUseCases.findById(1L);
            assertTrue(documentEntity.isEmpty());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
