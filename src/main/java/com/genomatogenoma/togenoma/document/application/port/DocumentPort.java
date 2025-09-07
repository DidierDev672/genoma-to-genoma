package com.genomatogenoma.togenoma.document.application.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;

@Repository
public interface DocumentPort extends JpaRepository<DocumentEntity, Long> {

}
