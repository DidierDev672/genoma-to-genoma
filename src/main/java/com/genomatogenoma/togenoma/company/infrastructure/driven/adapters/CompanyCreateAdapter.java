package com.genomatogenoma.togenoma.company.infrastructure.driven.adapters;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import com.genomatogenoma.togenoma.company.infrastructure.driven.mappers.CompanyMapper;
import com.genomatogenoma.togenoma.company.infrastructure.driven.repositories.CompanyJpaRepository;
import com.genomatogenoma.togenoma.shared.CreateGeneric;

import java.util.Optional;

public class CompanyCreateAdapter implements CreateGeneric<CompanyEntities> {
    private final CompanyJpaRepository repository;
    private final CompanyMapper companyMapper;

    public CompanyCreateAdapter(CompanyJpaRepository repository, CompanyMapper companyMapper) {
        this.repository = repository;
        this.companyMapper = companyMapper;
    }
    @Override
    public Optional<CompanyEntities> create(CompanyEntities entity) throws Exception {
        CompanyEntity companyEntity = companyMapper.COMPANY_ENTITY(entity);
        CompanyEntity savedEntity = repository.save(companyEntity);
        return Optional.of(companyMapper.COMPANY_ENTITIES(savedEntity));
    }
}
