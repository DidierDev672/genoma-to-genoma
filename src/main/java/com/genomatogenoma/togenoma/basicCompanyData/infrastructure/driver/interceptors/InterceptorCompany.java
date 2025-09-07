package com.genomatogenoma.togenoma.basicCompanyData.infrastructure.driver.interceptors;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genomatogenoma.togenoma.basicCompanyData.domain.entities.CompanyEntity;
import com.genomatogenoma.togenoma.basicCompanyData.domain.repositories.CompanyDataUseCases;
import com.genomatogenoma.togenoma.basicCompanyData.infrastructure.driven.DTO.CompanyDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class InterceptorCompany implements HandlerInterceptor {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final CompanyDataUseCases companyRepository;
    private static final Logger logger = LoggerFactory.getLogger(InterceptorCompany.class);

    public InterceptorCompany(CompanyDataUseCases companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (request instanceof ContentCachingRequestWrapper wrapper) {
            String body = new String(wrapper.getContentAsByteArray(), request.getCharacterEncoding());
            logger.info("Body" + body);

        }
        if ("POST".equalsIgnoreCase(request.getMethod()) && request.getRequestURI().contains("/api/companies")) {
            try {
                String body = getBody(request);
                CompanyDTO companyDTO = objectMapper.readValue(body, CompanyDTO.class);

                logger.info("Registered interceptor Company: " + companyDTO.getCompanyName());
                CompanyEntity companyEntity = this.mapToEntity(companyDTO);
                companyRepository.save(companyEntity);
            } catch (Exception e) {
                logger.error("Error in interceptor Company: " + e.getMessage());
            }
        }

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            String uri = request.getRequestURI();

            if (uri.startsWith("/api/companies")) {
                logger.info("📌 Interceptor: GET request to basic company data -> " + uri);

            }
        }

        return true;
    }

    private String getBody(HttpServletRequest request) throws Exception {
        return request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    }

    private CompanyEntity mapToEntity(CompanyDTO companyDTO) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCompanyName(companyDTO.getCompanyName());
        companyEntity.setNit(companyDTO.getNit());
        companyEntity.setAddress(companyDTO.getAddress());
        companyEntity.setPhone(companyDTO.getPhone());
        companyEntity.setEmail(companyDTO.getEmail());
        companyEntity.setLegalRepresentative(companyDTO.getLegalRepresentative());
        companyEntity.setDateIncorporation(java.time.LocalDate.parse(companyDTO.getDateIncorporation()));
        companyEntity.setState(CompanyEntity.StateCompany.ACTIVE);
        return companyEntity;
    }
}
