package com.tahto.smallTalks.controller;

import com.tahto.smallTalks.service.VerificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verification")
public class VerificationController {
    private final VerificationService service;

    public VerificationController(VerificationService service) {
        this.service = service;
    }

    @PostMapping("/{entry}")
    public String verificationSmallTalks(@PathVariable String entry) {
        return service.verificationSmallTalks(entry);
    }
}
