package com.genomatogenoma.togenoma.company.infrastructure.driven.mappers;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(CompanyMapper.class);
    CompanyEntities COMPANY_ENTITIES(CompanyEntity companyEntity);

    CompanyEntity COMPANY_ENTITY(CompanyEntities companyEntities);
}
