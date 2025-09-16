package com.genomatogenoma.togenoma.documents.domain.entities;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentEntities {
    private Long id;
    private String nameDocument;
    private String storageRoute; //? Path o URL en S3, GCP, Azure Blob.
    private String typeDocument; //? PDF, DOCX, TXT, etc.
    private CompanyEntities companyEntities;
}
