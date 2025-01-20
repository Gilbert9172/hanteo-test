package com.hanteo.category.infra.controller.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int code;
    private final String message;

    @Builder
    private ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
