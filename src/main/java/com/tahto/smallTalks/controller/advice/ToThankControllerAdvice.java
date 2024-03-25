package com.tahto.smallTalks.controller.advice;

import com.tahto.smallTalks.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ToThankControllerAdvice {

    @ExceptionHandler(ToThankNullException.class)
    public ResponseEntity<Object> catchNullError() {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "ERRO: Verique os campos do agradecimento um ou mais estao vazios");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(FindToThankNullException.class)
    public ResponseEntity<Object> catchFindNullError() {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "ERRO: Agradecimento não encontrado com este ID");
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ToThankAlreadyExistsNullException.class)
    public ResponseEntity<Object> catchAlreadyExists() {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "ERRO: Agradecimento ja exite na base de dados!");
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
