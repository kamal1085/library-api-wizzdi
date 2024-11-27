package com.compare.comparenocode.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.compare.comparenocode.entity.BookInstance;
import com.compare.comparenocode.repository.BookInstanceRepository;

@Service
public class BookInstanceService {

    private final BookInstanceRepository bookInstanceRepository;

    public BookInstanceService(BookInstanceRepository bookInstanceRepository) {
        this.bookInstanceRepository = bookInstanceRepository;
    }

    public List<BookInstance> findAll() {
        return bookInstanceRepository.findAll();
    }

    public BookInstance findById(Long id) {
        return bookInstanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookInstance not found with id: " + id));
    }

    public BookInstance save(BookInstance bookInstance) {
        return bookInstanceRepository.save(bookInstance);
    }

    public BookInstance update(Long id, BookInstance bookInstance) {
        BookInstance existing = findById(id);
        bookInstance.setId(existing.getId());
        return bookInstanceRepository.save(bookInstance);
    }

    public void delete(Long id) {
        bookInstanceRepository.deleteById(id);
    }
}
