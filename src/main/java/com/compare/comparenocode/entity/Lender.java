package com.compare.comparenocode.entity;

import javax.persistence.Entity;
import com.compare.comparenocode.entity.Author;
import com.compare.comparenocode.entity.Genre;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Lender {
    @Id @GeneratedValue
    private Long id;
    private String title;

    @ManyToMany
    @JoinTable(name = "lender_book_instance")
    private List<BookInstance> bookInstanceList;

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