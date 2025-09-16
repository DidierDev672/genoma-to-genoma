package com.genomatogenoma.togenoma.documentPermisson.infrastructure.driven.entities;

import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import com.genomatogenoma.togenoma.documentPermisson.domain.enums.PermissonType;
import com.genomatogenoma.togenoma.documents.infrastructure.driven.entities.DocumentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "g_document_permisson")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentPermissonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private DocumentEntity documentEntities;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntities;

    @Enumerated(EnumType.STRING)
    private PermissonType permissonType;

    private LocalDateTime dateGranted;
}
