package com.genomatogenoma.togenoma.company.infrastructure.driven.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyEntityTest {
    @Test
    void testCompanyEntitySettersAndGetters(){
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(1L);
        companyEntity.setNameCompany("Test Company");
        companyEntity.setActive(true);


        assertEquals(1L, companyEntity.getId());
        assertEquals("Test Company", companyEntity.getNameCompany());
        assertTrue(companyEntity.isActive());
    }

    @Test
    void testCompanyEntityBuilder(){
        CompanyEntity entity = CompanyEntity.builder()
                .id(2L)
                .nameCompany("Builder Company")
                .active(false)
                .build();

        assertEquals(2L, entity.getId());
        assertEquals("Builder Company", entity.getNameCompany());
        assertFalse(entity.isActive());
    }
}
