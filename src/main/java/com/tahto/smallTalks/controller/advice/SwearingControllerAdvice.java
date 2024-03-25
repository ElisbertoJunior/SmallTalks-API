package com.tahto.smallTalks.controller.advice;

import com.tahto.smallTalks.exception.SwearingAlreadyExistsNullException;
import com.tahto.smallTalks.exception.FindSwearingNullException;
import com.tahto.smallTalks.exception.SwearingNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SwearingControllerAdvice {

    @ExceptionHandler(SwearingNullException.class)
    public ResponseEntity<Object> catchNullError() {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "ERRO: Verique os campos do xingamento um ou mais estao vazios");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(FindSwearingNullException.class)
    public ResponseEntity<Object> catchFindNullError() {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "ERRO: xingamento não encontrado com este ID");
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(SwearingAlreadyExistsNullException.class)
    public ResponseEntity<Object> catchAlreadyExists() {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "ERRO: xingamento ja exite na base de dados!");
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
