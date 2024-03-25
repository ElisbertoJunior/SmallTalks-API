package com.tahto.smallTalks.controller;

import com.tahto.smallTalks.entity.ToThank;
import com.tahto.smallTalks.service.ToThankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thank")
public class ToThankController {

    private final ToThankService service;

    public ToThankController(ToThankService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ToThank>> getAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<ToThank> add(ToThank toThank) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(toThank));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToThank> update(@PathVariable Long id, @RequestBody ToThank toThank) {
        return ResponseEntity.ok().body(service.update(id, toThank));
    }

    @DeleteMapping
    public ResponseEntity<List<ToThank>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body(service.findAll());
    }

}
