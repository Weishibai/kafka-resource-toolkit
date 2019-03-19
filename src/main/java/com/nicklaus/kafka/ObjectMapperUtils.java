package com.nicklaus.kafka;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json serializer
 *
 * @author weishibai
 * @date 2019/03/19 11:02 AM
 */
public class ObjectMapperUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> byte[] writeValue(T obj) {
        try {
            return OBJECT_MAPPER.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static <T> T readValue(byte[] serialized, Class<T> clz) {
        try {
            return OBJECT_MAPPER.readValue(serialized, clz);
        } catch (IOException e) {
            return null;
        }
    }
}
