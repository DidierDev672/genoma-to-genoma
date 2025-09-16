package com.genomatogenoma.togenoma.documents.infrastructure.driven.mappers;


import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.entities.DocumentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    DocumentMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(DocumentMapper.class);

    DocumentEntity DOCUMENT_ENTITY(DocumentEntities documentEntities);

    DocumentEntities DOCUMENT_ENTITIES(DocumentEntity documentEntity);
}
