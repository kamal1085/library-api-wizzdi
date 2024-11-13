package com.compare.comparenocode.service;

import com.compare.comparenocode.entity.Book;
import com.compare.comparenocode.repository.BookRepository;
import com.compare.comparenocode.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Other CRUD methods...
}