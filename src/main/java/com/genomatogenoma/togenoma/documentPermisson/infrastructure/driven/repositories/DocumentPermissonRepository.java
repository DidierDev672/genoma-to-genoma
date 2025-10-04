package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.repositories;


import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.entities.DocumentPermissonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentPermissonRepository extends JpaRepository<DocumentPermissonEntity, Long> {

}
