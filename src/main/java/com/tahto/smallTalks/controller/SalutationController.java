package com.tahto.smallTalks.controller;

import com.tahto.smallTalks.entity.Salutation;
import com.tahto.smallTalks.service.SalutationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salutation")
public class SalutationController {

    private final SalutationService service;

    public SalutationController(SalutationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Salutation>> getAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Salutation> add(@RequestBody Salutation salutation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(salutation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salutation> update(@PathVariable Long id, @RequestBody Salutation salutation) {
        return ResponseEntity.ok().body(service.updateSalutation(id, salutation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Salutation>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body(service.findAll());
    }
}
