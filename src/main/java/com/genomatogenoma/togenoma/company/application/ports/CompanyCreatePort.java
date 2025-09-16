package com.genomatogenoma.togenoma.company.application.ports;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;

import java.util.Optional;

public interface CompanyCreatePort {
    Optional<CompanyEntities> create(CompanyEntities companyEntities) throws Exception;
}
