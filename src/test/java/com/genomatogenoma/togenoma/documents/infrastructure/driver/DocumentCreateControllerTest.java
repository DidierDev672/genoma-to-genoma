package com.genomatogenoma.togenoma.documents.infrastructure.driver;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.genomatogenoma.togenoma.documents.application.useCases.CreateDocumentUseCases;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.documents.infrastructure.driver.rest.DocumentCreateController;
import com.genomatogenoma.togenoma.utils.interceptors.SanitizingStringArgumentResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = DocumentCreateController.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SanitizingStringArgumentResolver.class))
public class DocumentCreateControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CreateDocumentUseCases createDocumentPermissonUseCases;

    @Test
    void shouldCreateDocumentSuccessfully() throws Exception {
        //? Given
        DocumentEntities documentEntities = new DocumentEntities();
        documentEntities.setNameDocument("Test Document");
        documentEntities.setId(1L);

        DocumentEntities savedDocument = new DocumentEntities();
        savedDocument.setId(1L);
        savedDocument.setNameDocument("Test Document");

        when(createDocumentPermissonUseCases.create(any(DocumentEntities.class)))
                .thenReturn(Optional.of(savedDocument));

        //? When & Then
        mockMvc.perform(post("/api/documents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(documentEntities)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("The document has been created with name: Test Document")));

        verify(createDocumentPermissonUseCases, times(1)).create(any(DocumentEntities.class));

    }

}
