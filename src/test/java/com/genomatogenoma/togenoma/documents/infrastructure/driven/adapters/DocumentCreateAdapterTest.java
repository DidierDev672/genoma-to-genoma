package com.genomatogenoma.togenoma.documents.infrastructure.driven.adapters;

import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.entities.DocumentEntity;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.mappers.DocumentMapper;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.repotories.DocumentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class DocumentCreateAdapterTest {
    private DocumentRepository repository;
    private DocumentMapper documentMapper;
    private DocumentCreateAdapters createAdapters;

    @BeforeEach
    void setUp(){
        repository = org.mockito.Mockito.mock(DocumentRepository.class);
        documentMapper = org.mockito.Mockito.mock(DocumentMapper.class);
        createAdapters = new DocumentCreateAdapters(repository, documentMapper);
    }

    @Test
    void testCreateReturnsSavedCompanyEntities() throws Exception {
        DocumentEntities documentEntities = DocumentEntities.builder().id(1L).nameDocument("Document Test").build();
        DocumentEntity documentEntity = DocumentEntity.builder().id(1L).nameDocument("Document Test").build();

        when(documentMapper.DOCUMENT_ENTITY(documentEntities)).thenReturn(documentEntity);
        when(repository.save(documentEntity)).thenReturn(documentEntity);
        when(documentMapper.DOCUMENT_ENTITIES(documentEntity)).thenReturn(documentEntities);

        Optional<DocumentEntities> entity = createAdapters.create(documentEntities);

        assertTrue(entity.isPresent());
        assertEquals(documentEntities, entity.get());
        verify(repository, times(1)).save(documentEntity);
        verify(documentMapper).DOCUMENT_ENTITIES(documentEntity);
    }
}
