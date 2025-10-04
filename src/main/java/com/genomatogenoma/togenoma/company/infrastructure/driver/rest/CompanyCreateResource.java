package com.genomatogenoma.togenoma.company.infrastructure.driver.rest;

import com.genomatogenoma.togenoma.company.application.useCases.CompanyCreateUseCases;
import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.utils.response.ApiResponse;
import com.genomatogenoma.togenoma.utils.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyCreateResource {

    private final CompanyCreateUseCases companyCreateUseCases;

    public CompanyCreateResource(CompanyCreateUseCases companyCreateUseCases) {
        this.companyCreateUseCases = companyCreateUseCases;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> createCompany(@RequestBody CompanyEntities companyEntities) throws Exception {
        if(companyEntities == null || companyEntities.getNameCompany() == null || companyEntities.getNit() == null) {
            return ResponseHandler.error("Company data is required", HttpStatus.CONFLICT);
        }

        companyCreateUseCases.create(companyEntities);
        return ResponseHandler.success(companyEntities, "Company created successfully");
    }
}
