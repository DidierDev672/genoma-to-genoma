package com.genomatogenoma.togenoma.basicCompanyData.infrastructure.driver.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.genomatogenoma.togenoma.basicCompanyData.domain.entities.CompanyEntity;
import com.genomatogenoma.togenoma.basicCompanyData.domain.repositories.CompanyDataUseCases;
import com.genomatogenoma.togenoma.utils.response.ApiResponse;
import com.genomatogenoma.togenoma.utils.response.ResponseHandler;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyDataUseCases companyService;

    public CompanyController(CompanyDataUseCases companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> create(@RequestBody CompanyEntity company) {
        return ResponseHandler.success(null, "The basic company data has been successfully created");
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CompanyEntity>>> getAll() {
        return ResponseHandler.success(companyService.findAll(),
                "All data of the registered company have been successfully obtained");
    }
}
