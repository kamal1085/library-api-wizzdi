package com.compare.comparenocode.repository;
import com.compare.comparenocode.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}