package com.genomatogenoma.togenoma.company.domain.test;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.domain.enums.PersonType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyTest {
    @Test
    void testCompanyEntitiesBuilderAndGetters(){
        LocalDate date = LocalDate.of(2020, 1, 1);
        CompanyEntities companyEntities = CompanyEntities.builder()
                .id(1L)
                .nameCompany("Test Company")
                .nit("123456")
                .dv("1")
                .legalName("Legal Name")
                .tradeName("Trade Name")
                .personType(PersonType.NATURAL)
                .ciiuCode("A123")
                .taxRegime("General")
                .incorporationDate(date)
                .chamberRegistration("Reg123")
                .legalRepresentative("Rep Name")
                .legalRepresentativeId("987654")
                .rutStatus("Active")
                .email("test@example.com")
                .phone("123456789")
                .website("www.test.com.co")
                .address("Test Address")
                .active(true)
                .build();

        assertEquals(1L, companyEntities.getId());
        assertEquals("Test Company", companyEntities.getNameCompany());
        assertEquals("123456", companyEntities.getNit());
        assertEquals(PersonType.NATURAL, companyEntities.getPersonType());
        assertTrue(companyEntities.isActive());
    }
}
