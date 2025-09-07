package com.genomatogenoma.togenoma.utils.interceptors;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.genomatogenoma.togenoma.utils.sanitizer.StringSanitizer;

@Component
public class SanitizingStringArgumentResolver implements HandlerMethodArgumentResolver {
    private final StringSanitizer sanitizer;

    public SanitizingStringArgumentResolver(StringSanitizer sanitizer) {
        this.sanitizer = sanitizer;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(String.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String paramValue = webRequest.getParameter(parameter.getParameterName());
        return sanitizer.sanitize(paramValue);
    }
}
