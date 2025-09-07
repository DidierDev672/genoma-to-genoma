package com.genomatogenoma.togenoma.utils.sanitizer;

import org.springframework.stereotype.Component;

@Component
public class StringSanitizer {
    /**
     * Sanea un string removiendo espacios extra,
     * Eliminando caracteres peligrosos y
     * Normalizando texto.
     */
    public String sanitize(String input) {
        if (input == null) {
            return "";
        }

        String result = input.trim();
        result = result.replaceAll("[<>\\\"'%;()&+]", "");
        result = result.replaceAll("\\\\s{2,}", "");
        return result;
    }
}
