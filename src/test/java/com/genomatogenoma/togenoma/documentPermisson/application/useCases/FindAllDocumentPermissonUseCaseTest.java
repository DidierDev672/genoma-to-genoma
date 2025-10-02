package com.genomatogenoma.togenoma.documentPermisson.application.useCases;

import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindAllDocumentPermissonUseCaseTest {
    @Test
    void testPermissonFindAllReturnsExpectedResult() throws Exception {
        FindAllGeneric<DocumentPermissonEntities> findAllGeneric = mock(FindAllGeneric.class);

        DocumentPermissonEntities documentPermissonEntities = new DocumentPermissonEntities();
        List<DocumentPermissonEntities> permissonEntities = new ArrayList<>();

        permissonEntities.add(documentPermissonEntities);

        when(findAllGeneric.findAll()).thenReturn(Optional.of(permissonEntities));

        FindAllDocumentPermissonUseCases findAllDocumentPermissonUseCases = new FindAllDocumentPermissonUseCases(findAllGeneric);
        Optional<List<DocumentPermissonEntities>> currentResult = findAllDocumentPermissonUseCases.findAll();

        assertTrue(currentResult.isPresent());
        assertEquals(permissonEntities, currentResult.get());
        assertEquals(1, currentResult.get().size());
        verify(findAllGeneric, times(1)).findAll();
    }
}
