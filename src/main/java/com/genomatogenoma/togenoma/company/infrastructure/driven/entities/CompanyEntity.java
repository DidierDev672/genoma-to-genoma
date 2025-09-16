package com.genomatogenoma.togenoma.company.infrastructure.driven.entities;

import com.genomatogenoma.togenoma.company.domain.enums.PersonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "g_company")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


   @Column(name = "name_company", nullable = false)
    private String nameCompany;

    @Column(name = "NIT", nullable = false, length = 20)
    private String nit;

    @Column(name = "dv", length = 2)
    private String dv;

    @Column(name = "legal_name", nullable = false, length = 250)
    private String legalName;

    @Column(name = "trade_name", length = 250)
    private String tradeName;

    @Enumerated(EnumType.STRING)
    @Column(name = "person_type", length = 20, nullable = false)
    private PersonType personType;

    @Column(name = "ciiu_code", length = 20)
    private String ciiuCode;

    @Column(name = "tax_regime", length = 50)
    private String taxRegime;


    @Column(name = "incorporation_date")
    private LocalDate incorporationDate;

    @Column(name = "chamber_registration", length = 100)
    private String chamberRegistration;

    @Column(name = "chamber_registration_date")
    private LocalDate chamberRegistrationDate;

    @Column(name = "legal_representative", length = 250)
    private String legalRepresentative;

    @Column(name = "legal_representative_id", length = 50)
    private String legalRepresentativeId;

    @Column(name = "rut_status", length = 50)
    private String rutStatus;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "website", length = 200)
    private String website;

    @Column(name = "address", length = 250)
    private String address;

    @Column(name = "active", nullable = false)
    private boolean active;
}
