package com.genomatogenoma.togenoma.company.infrastructure.driven.mappers;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CompanyMapperTest {
    @Test
    void testEntityToDomain(){
        CompanyEntity entity = CompanyEntity.builder()
                .id(1L)
                .nameCompany("Test Company")
                .active(true)
                .build();

        CompanyEntities domain = CompanyMapper.INSTANCE.COMPANY_ENTITIES(entity);

        assertNotNull(domain);
        assertEquals(entity.getId(), domain.getId());
        assertEquals(entity.getNameCompany(), domain.getNameCompany());
        assertEquals(entity.isActive(), domain.isActive());
    }

    @Test
    void testDomainToEntity(){
        CompanyEntities domain = CompanyEntities.builder()
                .id(2L)
                .nameCompany("Domain Company")
                .active(false)
                .build();

        CompanyEntity entity = CompanyMapper.INSTANCE.COMPANY_ENTITY(domain);

        assertNotNull(domain);
        assertEquals(domain.getId(), entity.getId());
        assertEquals(domain.getNameCompany(), entity.getNameCompany());
        assertEquals(domain.isActive(), entity.isActive());
    }
}
