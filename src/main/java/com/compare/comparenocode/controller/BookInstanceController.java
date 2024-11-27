package com.compare.comparenocode.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.compare.comparenocode.service.BookInstanceService;
import com.compare.comparenocode.entity.BookInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/book-instances")
public class BookInstanceController {

    private final BookInstanceService bookInstanceService;

    public BookInstanceController(BookInstanceService bookInstanceService) {
        this.bookInstanceService = bookInstanceService;
    }

    @GetMapping
    public ResponseEntity<List<BookInstance>> getAllBookInstances() {
        return ResponseEntity.ok(bookInstanceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookInstance> getBookInstanceById(@PathVariable Long id) {
        return ResponseEntity.ok(bookInstanceService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BookInstance> createBookInstance(@RequestBody BookInstance bookInstance) {
        return ResponseEntity.ok(bookInstanceService.save(bookInstance));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookInstance> updateBookInstance(@PathVariable Long id, @RequestBody BookInstance bookInstance) {
        return ResponseEntity.ok(bookInstanceService.update(id, bookInstance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookInstance(@PathVariable Long id) {
        bookInstanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
