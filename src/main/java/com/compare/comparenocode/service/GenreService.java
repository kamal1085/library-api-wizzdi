package com.compare.comparenocode.service;

import com.compare.comparenocode.entity.Genre;
import com.compare.comparenocode.repository.GenreRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }
}