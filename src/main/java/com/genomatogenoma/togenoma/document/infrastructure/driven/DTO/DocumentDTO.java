package com.genomatogenoma.togenoma.document.infrastructure.driven.DTO;

import org.hibernate.annotations.ManyToAny;

import com.genomatogenoma.togenoma.basicCompanyData.domain.entities.CompanyEntity;

import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {
    private Long id;
    private String title;
    private String type;
    private String storagePath;

    @ManyToAny
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity ownerCompany;
}
