package com.compare.comparenocode.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Book {
    @Id @GeneratedValue
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToMany
    @JoinTable(name = "book_genre")
    private List<Genre> genres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}