package com.genomatogenoma.togenoma.documents.infrastructure.driven.adapters;

import com.genomatogenoma.togenoma.documents.application.useCases.FindAllDocumentUseCases;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DocumentFindAllAdapterTest {
    @Test
    void testDocumentFindAllReturnsExpectedResult() throws Exception {
        FindAllGeneric<DocumentEntities> findAllGeneric = mock(FindAllGeneric.class);

        DocumentEntities documentEntities = new DocumentEntities();
        List<DocumentEntities> documentEntitiesList = new ArrayList<>();

        documentEntitiesList.add(documentEntities);

        when(findAllGeneric.findAll()).thenReturn(Optional.of(documentEntitiesList));

        FindAllDocumentUseCases findAllDocumentUseCases = new FindAllDocumentUseCases(findAllGeneric);
        Optional<List<DocumentEntities>> currentResult = findAllDocumentUseCases.findAll();


        assertTrue(currentResult.isPresent());
        assertEquals(documentEntitiesList, currentResult.get());
        assertEquals(1, currentResult.get().size());
        verify(findAllGeneric, times(1)).findAll();
    }
}
