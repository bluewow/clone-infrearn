package com.clone.inflearn.util.converter;

import com.clone.inflearn.util.exception.CustomException;
import com.clone.inflearn.util.exception.ErrorCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import org.springframework.core.GenericTypeResolver;

//@Converter
public class JsonConverter<T> implements AttributeConverter<T, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Java → DB (JSON 문자열)
    @Override
    public String convertToDatabaseColumn(T attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new CustomException(ErrorCode.JSON);
        }
    }

    // DB → Java 객체 (제네릭 타입)
    @Override
    public T convertToEntityAttribute(String dbData) {
        Class<?> aClass = GenericTypeResolver.resolveTypeArgument(getClass(), JsonConverter.class);
        try {
            return (T) objectMapper.readValue(dbData, aClass);
        } catch (JsonProcessingException e) {
            throw new CustomException(ErrorCode.JSON);
        }
    }
}
