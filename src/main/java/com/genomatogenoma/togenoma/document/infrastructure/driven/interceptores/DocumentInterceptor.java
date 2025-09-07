package com.genomatogenoma.togenoma.document.infrastructure.driven.interceptores;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genomatogenoma.togenoma.document.application.useCases.DocumentUseCases;
import com.genomatogenoma.togenoma.document.domain.entities.DocumentEntity;
import com.genomatogenoma.togenoma.document.infrastructure.driven.DTO.DocumentDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DocumentInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(DocumentInterceptor.class);
    private final ObjectMapper objectMapper;
    private final DocumentUseCases documentUseCases;

    public DocumentInterceptor(ObjectMapper objectMapper, DocumentUseCases documentUseCases) {
        this.objectMapper = objectMapper;
        this.documentUseCases = documentUseCases;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if ("POST".equalsIgnoreCase(request.getMethod()) && request.getRequestURI().contains("/api/documents")) {
            try {
                if ("application/json".equalsIgnoreCase(request.getContentType())) {
                    String body = getBody(request);
                    DocumentDTO documentDTO = objectMapper.readValue(body, DocumentDTO.class);
                    this.documentUseCases.create(DocumentInterceptor.documentEntity(documentDTO));
                    logger.info("📌 Intercepted record: " + documentDTO.getTitle());
                } else {
                    logger.warn("⚠️ Request with unsupported content type: {}", request.getContentType());
                }

            } catch (Exception e) {
                logger.error("Error in document interceptor: " + e.getMessage());
            }
        }

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            String uri = request.getRequestURI();

            if (uri.startsWith("/api/documents")) {
                this.documentUseCases.all();
                logger.info("🗞 All documents have been successfully obtained");
            }
        }
        return true;
    }

    private String getBody(HttpServletRequest request) throws IOException {
        return request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    }

    private static DocumentEntity documentEntity(DocumentDTO documentDTO) {
        return new DocumentEntity(
                documentDTO.getId(),
                documentDTO.getTitle(),
                documentDTO.getType(),
                documentDTO.getStoragePath(),
                documentDTO.getOwnerCompany());
    }

}
