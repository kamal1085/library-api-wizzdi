package com.compare.comparenocode.service;

import com.compare.comparenocode.entity.AppUser;
import com.compare.comparenocode.repository.AppUserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService {
    private final AppUserRepository appUserRepository;

    public UserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }
    public void delete(Long id) {
        appUserRepository.deleteById(id);
    }
    public AppUser update(Long id, AppUser user) {
        AppUser existing = findById(id);
        user.setId(existing.getId());
        return appUserRepository.save(user);
    }
    public AppUser findById(Long id) {
        return appUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }
}