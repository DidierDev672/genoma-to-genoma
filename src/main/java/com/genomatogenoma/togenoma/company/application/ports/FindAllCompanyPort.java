package com.genomatogenoma.togenoma.company.application.ports;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;

import java.util.List;
import java.util.Optional;

public interface FindAllCompanyPort {
    Optional<List<CompanyEntities>> findAll() throws Exception;
}
