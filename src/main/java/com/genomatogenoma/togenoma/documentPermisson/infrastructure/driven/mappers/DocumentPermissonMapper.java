package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.mappers;

import com.genomatogenoma.togenoma.documentPermisson.domain.entities.DocumentPermissonEntities;
import com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.entities.DocumentPermissonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentPermissonMapper {
    DocumentPermissonMapper INSTANCE = Mappers.getMapper(DocumentPermissonMapper.class);

    DocumentPermissonEntities DOCUMENT_PERMISSON_ENTITIES(DocumentPermissonEntity documentPermissonEntity);

    DocumentPermissonEntity DOCUMENT_PERMISSON_ENTITY(DocumentPermissonEntities documentPermissonEntities);
}
