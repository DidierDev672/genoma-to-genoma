package com.genomatogenoma.togenoma.document.infrastructure.driven.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;
import com.genomatogenoma.togenoma.document.infrastructure.driven.DTO.DocumentDTO;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    DocumentDTO documentToDocumentDTO(DocumentEntity documentEntity);

    DocumentEntity documentDTOToDocument(DocumentDTO documentDTO);
}
