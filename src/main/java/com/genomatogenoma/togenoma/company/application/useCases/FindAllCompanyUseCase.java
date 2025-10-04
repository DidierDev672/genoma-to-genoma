package com.genomatogenoma.togenoma.company.application.useCases;

import com.genomatogenoma.togenoma.company.application.ports.FindAllCompanyPort;
import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;

import java.util.List;
import java.util.Optional;

public class FindAllCompanyUseCase implements FindAllCompanyPort {
    private final FindAllGeneric<CompanyEntities> companyEntitiesFindAllGeneric;

    public FindAllCompanyUseCase(FindAllGeneric<CompanyEntities> companyEntitiesFindAllGeneric){
        this.companyEntitiesFindAllGeneric = companyEntitiesFindAllGeneric;
    }

    @Override
    public Optional<List<CompanyEntities>> findAll() throws Exception {

        return this.companyEntitiesFindAllGeneric.findAll();

    }
}
