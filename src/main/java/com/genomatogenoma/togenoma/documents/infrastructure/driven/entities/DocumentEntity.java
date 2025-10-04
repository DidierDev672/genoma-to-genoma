package com.genomatogenoma.togenoma.documents.infrastructure.driven.entities;

import com.genomatogenoma.togenoma.company.domain.entities.CompanyEntities;
import com.genomatogenoma.togenoma.company.infrastructure.driven.entities.CompanyEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "g_documents")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_document", nullable = false)
    private String nameDocument;
    @Column(name = "storage_route", nullable = false)
    private String storageRoute;
    @Column(name = "type_document", nullable = false)
    private String typeDocument;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntities;


}
