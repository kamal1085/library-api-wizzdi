package com.compare.comparenocode.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.compare.comparenocode.entity.Lender;
import com.compare.comparenocode.repository.LenderRepository;

@Service
public class LenderService {

    private final LenderRepository lenderRepository;

    public LenderService(LenderRepository lenderRepository) {
        this.lenderRepository = lenderRepository;
    }

    public List<Lender> findAll() {
        return lenderRepository.findAll();
    }

    public Lender findById(Long id) {
        return lenderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lender not found with id: " + id));
    }

    public Lender save(Lender lender) {
        return lenderRepository.save(lender);
    }

    public Lender update(Long id, Lender lender) {
        Lender existing = findById(id);
        lender.setId(existing.getId());
        return lenderRepository.save(lender);
    }

    public void delete(Long id) {
        lenderRepository.deleteById(id);
    }
}
