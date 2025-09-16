package com.genomatogenoma.togenoma.documentPermisson.domain.entities;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.documentPermisson.domain.enums.PermissonType;
import com.genomatogenoma.togenoma.documents.domain.entities.DocumentEntities;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentPermissonEntities {
    private Long id;
    private DocumentEntities documentEntities;
    private CompanyEntities companyEntities;
    private PermissonType permissonType;
    private LocalDateTime dateGranted;
}
