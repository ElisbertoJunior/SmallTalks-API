package com.tahto.smallTalks.controller.advice;

import com.tahto.smallTalks.exception.FindSalutationNullException;
import com.tahto.smallTalks.exception.SalutationNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SalutationControllerAdvice {

    @ExceptionHandler(SalutationNullException.class)
    public ResponseEntity<Object> catchNullError() {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "ERRO: Verique os campos da saudação um ou mais estao vazios");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(FindSalutationNullException.class)
    public ResponseEntity<Object> catchFindNullError() {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "ERRO: Saudação não encontrado com este ID");
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
