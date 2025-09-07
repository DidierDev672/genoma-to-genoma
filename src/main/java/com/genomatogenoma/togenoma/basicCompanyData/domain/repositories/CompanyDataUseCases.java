package com.genomatogenoma.togenoma.basicCompanyData.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genomatogenoma.togenoma.basicCompanyData.domain.entities.CompanyEntity;

@Repository
public interface CompanyDataUseCases extends JpaRepository<CompanyEntity, Long> {
    boolean existsByCompanyName(String nit);
}
