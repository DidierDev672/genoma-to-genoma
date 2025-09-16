package com.genomatogenoma.togenoma.company.infrastructure.driver.config;

import com.genomatogenoma.togenoma.company.application.useCases.CompanyCreateUseCases;
import com.genomatogenoma.togenoma.company.application.useCases.FindAllCompanyUseCase;
import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.infrastructure.driven.adapters.CompanyCreateAdapter;
import com.genomatogenoma.togenoma.company.infrastructure.driven.adapters.CompanyFindAllAdapter;
import com.genomatogenoma.togenoma.company.infrastructure.driven.mappers.CompanyMapper;
import com.genomatogenoma.togenoma.company.infrastructure.driven.repositories.CompanyJpaRepository;
import com.genomatogenoma.togenoma.shared.CreateGeneric;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfig {
    @Bean
    public CompanyCreateAdapter companyCreateAdapter(CompanyJpaRepository repository, CompanyMapper companyMapper){
        return new CompanyCreateAdapter(repository, companyMapper);
    }

    @Bean
    public CompanyFindAllAdapter companyFindAllAdapter(CompanyJpaRepository companyJpaRepository, CompanyMapper companyMapper){
        return new CompanyFindAllAdapter(companyJpaRepository, companyMapper);
    }

    @Bean
    public CompanyCreateUseCases companyCreateUseCases(CreateGeneric<CompanyEntities> entitiesCreateGeneric){
        return new CompanyCreateUseCases(entitiesCreateGeneric);
    }

    @Bean
    public FindAllCompanyUseCase findAllCompanyUseCase(FindAllGeneric<CompanyEntities> companyEntitiesFindAllGeneric){
        return new FindAllCompanyUseCase(companyEntitiesFindAllGeneric);
    }

}
