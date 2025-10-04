package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driver.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.documentPermisson.application.useCases.CreateDocumentPermissonUseCases;
import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.documentPermisson.domain.enums.PermissonType;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.utils.sanitizer.StringSanitizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test Unitario para DocumentPermissonController
 *
 * IMPORTANTE: Este es un test UNITARIO del controller:
 *  - Usa WebMvcTest para levantar solo el controller (no el contexto completo)
 *  - Los casos de uso son MOCKS (No se ejecuta la lógica real)
 *  - No se conecta a base de datos
 */
@WebMvcTest(DocumentPermissonCreateController.class)
public class DocumentPermissonCreateControllerTest {
    //? MockMvc simula peticiones HTTP sin leventar el servidor
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CreateDocumentPermissonUseCases createUseCase;

    @MockitoBean
    private StringSanitizer stringSanitizer;

    private DocumentPermissonEntities documentPermissonEntities;

    @BeforeEach
    void setUp(){
        documentPermissonEntities = createDocumentPermisson(1L);
    }

    @Test
    @DisplayName("POST /api/document-permisson - Debe crear un permiso exitosamente")
    void testCreate_Success() throws Exception {
        when(createUseCase.permissonCreate(any(DocumentPermissonEntities.class))).thenReturn(Optional.of(documentPermissonEntities));

        mockMvc.perform(post("/api/document-permisson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(documentPermissonEntities)))
                //? Verificar status HTTP 201 CREATED
                .andExpect(status().isCreated())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Permissions for the document have been successfully created."));

        verify(createUseCase, times(1)).permissonCreate(any(DocumentPermissonEntities.class));
    }

    @Test
    @DisplayName("POST  /api/document-permisson - Debe retornar 400 cuando falla la creación")
    void testCreate_BadRequest() throws Exception {
        documentPermissonEntities.setCompanyEntities(null);

        mockMvc.perform(post("/api/document-permisson").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(documentPermissonEntities)))
                .andExpect(status().isConflict())
                .andExpect(content().contentType("text/plain;charset=UTF-8"));
        verify(createUseCase, never()).permissonCreate(any());
    }

    @Test
    @DisplayName("POST - Debe retornar 409 cuando CompanyEntities es null")
    void testCreate_CompanyIsNull() throws Exception {
        documentPermissonEntities.setCompanyEntities(null);

        mockMvc.perform(post("/api/document-permisson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(documentPermissonEntities)))
                .andExpect(status().isConflict())
                .andExpect(content().contentType("text/plain;charset=UTF-8"));

        verify(createUseCase, never()).permissonCreate(any());
    }

    @Test
    @DisplayName("POST - Debe retornar 409 cuando DocumentEntities es null")
    void testCreate_DocumentIsNull() throws Exception {
        documentPermissonEntities.setDocumentEntities(null);

        mockMvc.perform(post("/api/document-permisson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(documentPermissonEntities)))
                .andExpect(status().isConflict())
                .andExpect(content().contentType("text/plain;charset=UTF-8"));

        verify(createUseCase, never()).permissonCreate(any());
    }

    @Test
    @DisplayName("POST - Debe retornar 409 cuando ambos son null")
    void testCreate_BothAreNull() throws Exception {
        documentPermissonEntities.setCompanyEntities(null);
        documentPermissonEntities.setDocumentEntities(null);

        mockMvc.perform(post("/api/document-permisson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(documentPermissonEntities)))
                .andExpect(status().isConflict())
                .andExpect(content().contentType("text/plain;charset=UTF-8"));

        verify(createUseCase, never()).permissonCreate(any());
    }

    @Test
    @DisplayName("POST - Debe retornar 409 cuando el caso de uso retorna empty")
    void testCreate_UseCaseReturnsEmpty() throws Exception {
        when(createUseCase.permissonCreate(any(DocumentPermissonEntities.class))).thenReturn(Optional.empty());

        mockMvc.perform(post("/api/document-permisson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(documentPermissonEntities)))
                .andExpect(status().isConflict())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("The permissions for the document could not be created. You must review the information. Please enter."));

        verify(createUseCase, times(1)).permissonCreate(any(DocumentPermissonEntities.class));
    }

    @Test
    @DisplayName("POST - Debe retornar 400 cuando el JSON es malformado")
    void testCreate_InvalidJson() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/api/document-permisson")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{invalid json}"))
                .andExpect(status().isBadRequest());  // 400

        verify(createUseCase, never()).permissonCreate(any());
    }

    private DocumentPermissonEntities createDocumentPermisson(Long id){
        DocumentPermissonEntities permisson = new DocumentPermissonEntities();
        permisson.setId(id);
        permisson.setPermissonType(PermissonType.READING);
        permisson.setDateGranted(LocalDateTime.now());

        //! Datos simplificados para el test
        DocumentEntities document = new DocumentEntities();
        document.setId(100L);
        document.setNameDocument("Test Document");
        permisson.setDocumentEntities(document);


        CompanyEntities company = new CompanyEntities();
        company.setId(200L);
        company.setNameCompany("TechCorp");
        permisson.setCompanyEntities(company);
        return permisson;
    }
}
