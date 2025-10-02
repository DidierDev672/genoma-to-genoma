package com.genomatogenoma.togenoma.company.infrastructure.driver.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.genomatogenoma.togenoma.company.application.useCases.CompanyCreateUseCases;
import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.domain.enums.PersonType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyCreateControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CompanyCreateUseCases companyCreateUseCases;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    void shouldCompanyCreateResourceTest() throws Exception{
        CompanyEntities companyEntities =  CompanyEntities.builder()
                .id(1L)
                .nameCompany("Name Company")
                .nit("1234567890")
                .incorporationDate(LocalDate.of(2025, 1, 15))
                .build();

        //? Configurar mock para retornar el objeto ID
        when(companyCreateUseCases.create(any(CompanyEntities.class))).thenReturn(Optional.ofNullable(companyEntities));

        String jsonRequest = objectMapper.writeValueAsString(companyEntities);

        mockMvc.perform(post("/api/companies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isCreated());
    }

}
