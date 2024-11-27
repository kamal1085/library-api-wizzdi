package com.compare.comparenocode.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.compare.comparenocode.service.LenderService;
import com.compare.comparenocode.entity.Lender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/lenders")
public class LenderController {

    private final LenderService lenderService;

    public LenderController(LenderService lenderService) {
        this.lenderService = lenderService;
    }

    @GetMapping
    public ResponseEntity<List<Lender>> getAllLenders() {
        return ResponseEntity.ok(lenderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lender> getLenderById(@PathVariable Long id) {
        return ResponseEntity.ok(lenderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Lender> createLender(@RequestBody Lender lender) {
        return ResponseEntity.ok(lenderService.save(lender));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lender> updateLender(@PathVariable Long id, @RequestBody Lender lender) {
        return ResponseEntity.ok(lenderService.update(id, lender));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLender(@PathVariable Long id) {
        lenderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
