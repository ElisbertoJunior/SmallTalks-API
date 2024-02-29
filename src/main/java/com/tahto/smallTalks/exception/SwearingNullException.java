package com.tahto.smallTalks.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.Serial;

@ControllerAdvice
public class SwearingNullException extends NullPointerException{
    @Serial
    private static final long serialVersin = 1L;
}
