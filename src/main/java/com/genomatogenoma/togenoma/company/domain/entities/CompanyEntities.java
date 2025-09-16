package com.genomatogenoma.togenoma.company.domain.entities;

import com.genomatogenoma.togenoma.company.domain.enums.PersonType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntities {
    private Long id;
    private String nameCompany;
    private String nit;
    private String dv;
    private String legalName;
    private String tradeName;
    private PersonType personType;
    private String ciiuCode;
    private String taxRegime;
    private LocalDate incorporationDate;
    private String chamberRegistration;
    private String legalRepresentative;
    private String legalRepresentativeId;
    private String rutStatus;
    private String email;
    private String phone;
    private String website;
    private String address;
    private boolean active;
}
