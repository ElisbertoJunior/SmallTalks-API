package com.tahto.smallTalks.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.Serial;

@ControllerAdvice
public class ToThankAlreadyExistsNullException extends NullPointerException {
    @Serial
    private static final long serialVersion = 1L;
}
