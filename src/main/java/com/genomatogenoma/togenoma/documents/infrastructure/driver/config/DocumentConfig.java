package com.genomatogenoma.togenoma.documents.infrastructure.driver.config;

import com.genomatogenoma.togenoma.documents.application.useCases.CreateDocumentUseCases;
import com.genomatogenoma.togenoma.documents.application.useCases.FindAllDocumentUseCases;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.adapters.DocumentCreateAdapters;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.adapters.DocumentFindAllAdapters;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.mappers.DocumentMapper;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.repotories.DocumentRepository;
import com.genomatogenoma.togenoma.shared.CreateGeneric;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DocumentConfig {

    @Bean
    public DocumentCreateAdapters documentCreateAdapters(DocumentRepository repository, DocumentMapper documentMapper){
        return new DocumentCreateAdapters(repository, documentMapper);
    }

    @Bean
    public DocumentFindAllAdapters documentFindAllAdapters(DocumentRepository repository, DocumentMapper documentMapper){
        return new DocumentFindAllAdapters(repository, documentMapper);
    }

    @Bean
    public CreateDocumentUseCases createDocumentUseCases(CreateGeneric<DocumentEntities> entitiesCreateGeneric){
        return new CreateDocumentUseCases(entitiesCreateGeneric);
    }

    @Bean
    public FindAllDocumentUseCases findAllDocumentUseCases(FindAllGeneric<DocumentEntities> findAllGeneric){
        return new FindAllDocumentUseCases(findAllGeneric);
    }
}
