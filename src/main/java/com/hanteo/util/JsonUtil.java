package com.hanteo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class JsonUtil {

    public static String toJson(Object source) {
        var objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(source);
        } catch (Exception e) {
            throw new RuntimeException("json 변형 실패");
        }
    }

}
