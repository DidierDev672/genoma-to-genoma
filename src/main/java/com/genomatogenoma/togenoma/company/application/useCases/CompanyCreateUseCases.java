package com.genomatogenoma.togenoma.company.application.useCases;

import com.genomatogenoma.togenoma.company.application.ports.CompanyCreatePort;
import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.shared.CreateGeneric;

import java.util.Optional;

public class CompanyCreateUseCases implements CompanyCreatePort {
    private final CreateGeneric<CompanyEntities> entitiesCreateGeneric;

    public CompanyCreateUseCases(CreateGeneric<CompanyEntities> entitiesCreateGeneric) {
        this.entitiesCreateGeneric = entitiesCreateGeneric;
    }
    @Override
    public Optional<CompanyEntities> create(CompanyEntities companyEntities) throws Exception {
        return this.entitiesCreateGeneric.create(companyEntities);
    }
}
