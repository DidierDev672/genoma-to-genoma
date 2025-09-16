package com.genomatogenoma.togenoma.company.infrastructure.driven.adapters;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import com.genomatogenoma.togenoma.company.infrastructure.driven.mappers.CompanyMapper;
import com.genomatogenoma.togenoma.company.infrastructure.driven.repositories.CompanyJpaRepository;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyFindAllAdapter implements FindAllGeneric<CompanyEntities> {
    private final CompanyJpaRepository companyJpaRepository;
    private final CompanyMapper companyMapper;

    public CompanyFindAllAdapter(CompanyJpaRepository companyJpaRepository, CompanyMapper companyMapper){
        this.companyJpaRepository = companyJpaRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public Optional<List<CompanyEntities>> findAll() throws Exception {
        List<CompanyEntities> companyEntitiesList = new ArrayList<>();
        Iterable<CompanyEntity> companyEntities = this.companyJpaRepository.findAll();

        for(CompanyEntity entity : companyEntities){
            companyEntitiesList.add(companyMapper.COMPANY_ENTITIES(entity));
        }

        if(companyEntitiesList.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(companyEntitiesList);
    }
}
