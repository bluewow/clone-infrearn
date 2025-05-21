package com.clone.inflearn.util.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return Boolean.TRUE.equals(attribute) ? "TRUE" : "FALSE";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "TRUE".equalsIgnoreCase(dbData);
    }
}
