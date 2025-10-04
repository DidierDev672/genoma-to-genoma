package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driver.config;

import com.genomatogenoma.togenoma.documentPermisson.application.useCases.CreateDocumentPermissonUseCases;
import com.genomatogenoma.togenoma.documentPermisson.application.useCases.FindAllDocumentPermissonUseCases;
import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.adapters.DocumentPermissonCreateAdapters;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.adapters.DocumentPermissonFindAllAdapters;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.mappers.DocumentPermissonMapper;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.repositories.DocumentPermissonRepository;
import com.genomatogenoma.togenoma.shared.CreateGeneric;
import com.genomatogenoma.togenoma.shared.FindAllGeneric;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentPermissonConfig {
    @Bean
    public DocumentPermissonCreateAdapters documentPermissonCreateAdapters(
            DocumentPermissonRepository documentPermissonRepository,
            DocumentPermissonMapper documentPermissonMapper) {
        return new DocumentPermissonCreateAdapters(documentPermissonRepository, documentPermissonMapper);
    }

    @Bean
    public DocumentPermissonFindAllAdapters documentPermissonFindAllAdapters(DocumentPermissonRepository documentPermissonRepository,
                                                                      DocumentPermissonMapper documentPermissonMapper){
        return new DocumentPermissonFindAllAdapters(documentPermissonRepository, documentPermissonMapper);
    }

    @Bean
    public  CreateDocumentPermissonUseCases createDocumentPermissonUseCases(CreateGeneric<DocumentPermissonEntities> entitiesCreateGeneric){
        return new CreateDocumentPermissonUseCases(entitiesCreateGeneric);
    }

    @Bean
    public FindAllDocumentPermissonUseCases findAllDocumentPermissonUseCases(FindAllGeneric<DocumentPermissonEntities> findAllGeneric){
        return new FindAllDocumentPermissonUseCases(findAllGeneric);
    }
}
