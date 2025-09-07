package com.genomatogenoma.togenoma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.genomatogenoma.togenoma.basicCompanyData.infrastructure.driver.interceptors.InterceptorCompany;
import com.genomatogenoma.togenoma.document.infrastructure.driven.interceptores.DocumentInterceptor;
import com.genomatogenoma.togenoma.utils.interceptors.SanitizingStringArgumentResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private InterceptorCompany interceptorCompany;

    @Autowired
    private DocumentInterceptor documentInterceptor;

    private final SanitizingStringArgumentResolver resolverString;

    public WebConfig(InterceptorCompany interceptorCompany, DocumentInterceptor documentInterceptor,
            SanitizingStringArgumentResolver resolverString) {
        this.interceptorCompany = interceptorCompany;
        this.documentInterceptor = documentInterceptor;
        this.resolverString = resolverString;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorCompany)
                .addPathPatterns("/api/companies/**");

        registry.addInterceptor(documentInterceptor).addPathPatterns("/api/documents/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(resolverString);
    }
}
