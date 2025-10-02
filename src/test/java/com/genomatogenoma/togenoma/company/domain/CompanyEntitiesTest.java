package com.genomatogenoma.togenoma.company.domain;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.domain.enums.PersonType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
public class CompanyEntitiesTest {

    @Test
    void testNoArgsContructorAndSetterAndGetters(){
        CompanyEntities company = new CompanyEntities();

        company.setId(1L);
        company.setNameCompany("TechCorp");
        company.setNit("123456789");
        company.setDv("1");
        company.setLegalName("TechCorp S.A.");
        company.setTradeName("Tech Corporation");
        company.setPersonType(PersonType.JURIDICA);
        company.setCiiuCode("6201");
        company.setTaxRegime("General");
        company.setIncorporationDate(LocalDate.of(2020, 1, 1));
        company.setChamberRegistration("AB123");
        company.setLegalRepresentative("John Doe");
        company.setLegalRepresentativeId("987654321");
        company.setRutStatus("Activo");
        company.setEmail("contact@techcorp.com");
        company.setPhone("1234567890");
        company.setWebsite("www.techcorp.com");
        company.setAddress("123 Main St");
        company.setActive(true);

        assertEquals(1L, company.getId());
        assertEquals("TechCorp", company.getNameCompany());
        assertEquals("123456789", company.getNit());
        assertEquals("1", company.getDv());
        assertEquals("TechCorp S.A.", company.getLegalName());
        assertEquals("Tech Corporation", company.getTradeName());
        assertEquals(PersonType.JURIDICA, company.getPersonType());
        assertEquals("6201", company.getCiiuCode());
        assertEquals("General", company.getTaxRegime());
        assertEquals(LocalDate.of(2020, 1, 1), company.getIncorporationDate());
        assertEquals("AB123", company.getChamberRegistration());
        assertEquals("John Doe", company.getLegalRepresentative());
        assertEquals("987654321", company.getLegalRepresentativeId());
        assertEquals("Activo", company.getRutStatus());
        assertEquals("contact@techcorp.com", company.getEmail());
        assertEquals("1234567890", company.getPhone());
        assertEquals("www.techcorp.com", company.getWebsite());
        assertEquals("123 Main St", company.getAddress());
        assertTrue(company.isActive());
    }

    @Test
    void testAllArgsConstructor(){
        LocalDate date = LocalDate.of(2020, 2, 2);
        CompanyEntities company = new CompanyEntities(
                2L, "SoftInc", "987654321", "2", "SoftInc Ltda.",
                "Soft Inc.", PersonType.NATURAL, "6311", "Simplificado",
                date, "CD456", "Jane Smith", "123456789", "Pendiente",
                "info@softinc.com", "0987654321", "www.softinc.com",
                "456 Secondary St", false
        );

        assertEquals(2L, company.getId());
        assertEquals("SoftInc", company.getNameCompany());
        assertEquals("987654321", company.getNit());
        assertEquals("2", company.getDv());
        assertEquals("SoftInc Ltda.", company.getLegalName());
        assertEquals("Soft Inc.", company.getTradeName());
        assertEquals(PersonType.NATURAL, company.getPersonType());
        assertEquals("6311", company.getCiiuCode());
        assertEquals("Simplificado", company.getTaxRegime());
        assertEquals(date, company.getIncorporationDate());
        assertEquals("CD456", company.getChamberRegistration());
        assertEquals("Jane Smith", company.getLegalRepresentative());
        assertEquals("123456789", company.getLegalRepresentativeId());
        assertEquals("Pendiente", company.getRutStatus());
        assertEquals("info@softinc.com", company.getEmail());
        assertEquals("0987654321", company.getPhone());
        assertEquals("www.softinc.com", company.getWebsite());
        assertEquals("456 Secondary St", company.getAddress());
        assertFalse(company.isActive());
    }

    @Test
    void testBuilder(){
        LocalDate date = LocalDate.of(2021, 5, 10);
        CompanyEntities company = CompanyEntities.builder()
                .id(3L)
                .nameCompany("BuilderTest")
                .nit("555555555")
                .dv("3")
                .legalName("BuilderTest S.A.")
                .tradeName("Builder")
                .personType(PersonType.JURIDICA)
                .ciiuCode("9999")
                .taxRegime("General")
                .incorporationDate(date)
                .chamberRegistration("EF789")
                .legalRepresentative("Builder Joe")
                .legalRepresentativeId("111222333")
                .rutStatus("Activo")
                .email("builder@test.com")
                .phone("5555555555")
                .website("www.builder.com")
                .address("789 Builder Ave")
                .active(true)
                .build();

        assertEquals(3L, company.getId());
        assertEquals("BuilderTest", company.getNameCompany());
    }
}
