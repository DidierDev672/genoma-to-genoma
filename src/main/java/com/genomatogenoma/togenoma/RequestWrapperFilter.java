package com.genomatogenoma.togenoma;

import java.io.IOException;

import org.springframework.stereotype.Component;
import com.genomatogenoma.togenoma.document.infrastructure.driven.request.DocumentCachedBodyHttpServletRequest;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

@Component("customRequestWrapperFilters")
public class RequestWrapperFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            DocumentCachedBodyHttpServletRequest wrapperRequest = new DocumentCachedBodyHttpServletRequest(
                    httpServletRequest);

            chain.doFilter(wrapperRequest, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
