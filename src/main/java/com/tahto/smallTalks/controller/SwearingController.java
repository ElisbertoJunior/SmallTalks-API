package com.tahto.smallTalks.controller;

import com.tahto.smallTalks.entity.Swearing;
import com.tahto.smallTalks.service.SwearingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/swearing")
public class SwearingController {

    private final SwearingService service;

    public SwearingController(SwearingService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Swearing>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Swearing> add(@RequestBody Swearing swearing) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(swearing));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Swearing> update(@PathVariable Long id, @RequestBody Swearing swearing) {
        return ResponseEntity.ok().body(service.update(id, swearing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Swearing>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body(service.getAll());
    }


}
