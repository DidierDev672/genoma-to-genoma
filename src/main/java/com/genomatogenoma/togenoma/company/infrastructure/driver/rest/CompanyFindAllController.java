package com.genomatogenoma.togenoma.company.infrastructure.driver.rest;

import com.genomatogenoma.togenoma.company.application.useCases.FindAllCompanyUseCase;
import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.utils.response.ApiResponse;
import com.genomatogenoma.togenoma.utils.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyFindAllController {
    private final FindAllCompanyUseCase findAllCompanyUseCase;

    public CompanyFindAllController(FindAllCompanyUseCase findAllCompanyUseCase){
        this.findAllCompanyUseCase = findAllCompanyUseCase;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> findAllCompanies() throws Exception {
        Optional<List<CompanyEntities>> companyEntities = this.findAllCompanyUseCase.findAll();

        if(companyEntities.isEmpty()){
            return ResponseHandler.error("No companies were found registered in the system.", HttpStatus.CONFLICT);
        }

        return ResponseHandler.success(companyEntities,"The companies have been successfully obtained");
    }
}

