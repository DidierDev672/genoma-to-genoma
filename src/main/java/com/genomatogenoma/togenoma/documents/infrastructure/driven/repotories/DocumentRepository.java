package com.genomatogenoma.togenoma.documents.infrastructure.driven.repotories;

import com.genomatogenoma.togenoma.documents.infrastructure.driven.entities.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
}
