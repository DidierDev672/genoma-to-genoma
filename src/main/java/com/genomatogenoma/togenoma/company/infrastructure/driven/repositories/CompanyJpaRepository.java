package com.genomatogenoma.togenoma.company.infrastructure.driven.repositories;

import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJpaRepository extends CrudRepository<CompanyEntity, Long> {
}
