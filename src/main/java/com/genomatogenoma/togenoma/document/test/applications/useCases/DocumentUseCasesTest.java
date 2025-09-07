package com.genomatogenoma.togenoma.document.test.applications.useCases;

import com.genomatogenoma.togenoma.basicCompanyData.domain.entities.CompanyEntity;
import com.genomatogenoma.togenoma.document.application.port.DocumentPort;
import com.genomatogenoma.togenoma.document.application.useCases.DocumentUseCases;
import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;
import com.genomatogenoma.togenoma.utils.sanitizer.StringSanitizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentUseCasesTest {
    private  DocumentUseCases documentUseCases;
    private DocumentPort documentPort;
    private StringSanitizer sanitizer;

    @BeforeEach
    void setUp(){
        sanitizer = new StringSanitizer();
        documentUseCases = new DocumentUseCases(documentPort, sanitizer);
    }

    @Test
    void testCreate() throws Exception {
        DocumentEntity documentEntity = new DocumentEntity();
        CompanyEntity entity = new CompanyEntity();

        //! Company details

        entity.setId(4L);
        entity.setCompanyName("");
        entity.setNit("");
        entity.setAddress("");
        entity.setPhone("");
        entity.setEmail("");
        entity.setLegalRepresentative("");
        entity.setDateIncorporation(LocalDate.now());
        entity.setState(CompanyEntity.StateCompany.ACTIVE);

        documentEntity.setId(1L);
        documentEntity.setTitle(sanitizer.sanitize("Electrogram Results"));
        documentEntity.setType(sanitizer.sanitize("RESULT_EXAM"));
        documentEntity.setStoragePath(sanitizer.sanitize("/src/result/exam/"));
        documentEntity.setOwnerCompany(entity);

        Optional<DocumentEntity> document = Optional.of(new DocumentEntity());

        //* Creating the medical laboratory document
        Optional<DocumentEntity> created =  documentUseCases.create(documentEntity);
        assertEquals(document, created, "The medical laboratory document has been successfully created");
    }
}
