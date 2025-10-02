package com.genomatogenoma.togenoma.documentPermisson.application.useCases;
import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.shared.CreateGeneric;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreateDocumentPermissonUseCasesTest {
    @Test
    void testPermissonCreateReturnsExpectedResult() throws Exception {
        CreateGeneric<DocumentPermissonEntities> createGenericMock = mock(CreateGeneric.class);

        DocumentPermissonEntities inputEntity = new DocumentPermissonEntities();
        Optional<DocumentPermissonEntities> expectedResult = Optional.of(inputEntity);

        //? Configurar el mock para devolver el resultado esperando
        when(createGenericMock.create(inputEntity)).thenReturn(expectedResult);

        //? Instance el use case con el mock
        CreateDocumentPermissonUseCases useCases = new CreateDocumentPermissonUseCases(createGenericMock);
        //? Act: llama al método a testear
        Optional<DocumentPermissonEntities> actionResult = useCases.permissonCreate(inputEntity);

        //? Assert: Verifica el resultado y que se llamó al mock como corresponde
        assertEquals(expectedResult, actionResult);
        verify(createGenericMock, times(1)).create(inputEntity);
    }
}
