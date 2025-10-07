package com.demo.base.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
    }

    public static String toJson(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            log.error(ex.getMessage(), ex);
            return null;
        }
    }

    public static <T> byte[] toBytes(T object) {
        try {
            return objectMapper.writeValueAsBytes(object);
        } catch (JsonProcessingException ex) {
            log.error(ex.getMessage(), ex);
            return new byte[0];
        }
    }

    /**
     * Json to object
     *
     * @param string Json
     * @param clazz  Class of object
     * @param <T>    Type of object
     * @return Object
     */
    public static <T> T toObject(String string, Class<T> clazz) {
        try {
            return objectMapper.readValue(string, clazz);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * Json to object
     *
     * @param string        Json
     * @param typeReference Class of object
     * @param <T>           Type of object
     * @return Object
     */
    public static <T> T toObject(String string, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(string, typeReference);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * Byte to object
     *
     * @param bytes bytes
     * @param clazz Class of object
     * @param <T>   Type of object
     * @return Object
     */
    public static <T> T toObject(final byte[] bytes, final Class<T> clazz) {
        try {
            return objectMapper.readValue(bytes, clazz);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * Byte to object
     *
     * @param bytes         bytes
     * @param typeReference Class of object
     * @param <T>           Type of object
     * @return Object
     */
    public static <T> T toObject(final byte[] bytes, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(bytes, typeReference);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * List of bytes to list of objects
     *
     * @param list  List of bytes
     * @param clazz Class of object
     * @param <T>   Type of object
     * @return List object
     */
    public static <T> List<T> toObjects(List<byte[]> list, Class<T> clazz) {
        return list.stream().map(bytes -> toObject(bytes, clazz))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
