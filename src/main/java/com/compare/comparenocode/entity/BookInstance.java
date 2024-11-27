package com.compare.comparenocode.entity;

import javax.persistence.Entity;
import com.compare.comparenocode.entity.Book;
import com.compare.comparenocode.entity.Lender;
import com.compare.comparenocode.entity.Library;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class BookInstance {
    @Id @GeneratedValue
    private Long id;
    private String serialNumber;

    @ManyToOne
    private Book book;

    @ManyToMany(mappedBy = "bookInstanceList")
    private List<Lender> lenderList;


    @ManyToMany(mappedBy = "bookInstanceList")
    private List<Library> libraryList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Lender> getLenderList() {
        return lenderList;
    }

    public void setLenderList(List<Lender> lenderList) {
        this.lenderList = lenderList;
    }

    public void setLibraryList(List<Library> libraryList) {
        this.libraryList = libraryList;
    }

    public List<Library> getLibraryList() {
        return libraryList;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}