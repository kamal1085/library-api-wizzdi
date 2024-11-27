package com.compare.comparenocode.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.compare.comparenocode.entity.Library;
import com.compare.comparenocode.repository.LibraryRepository;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    public Library findById(Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found with id: " + id));
    }

    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    public Library update(Long id, Library library) {
        Library existing = findById(id);
        library.setId(existing.getId());
        return libraryRepository.save(library);
    }

    public void delete(Long id) {
        libraryRepository.deleteById(id);
    }
}
