package com.compare.comparenocode.service;

import com.compare.comparenocode.entity.AppUser;
import com.compare.comparenocode.repository.AppUserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class AuthService {
    private final AppUserRepository appUserRepository;

    public AuthService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser getUser(String userName) {
        AppUser foundUser = appUserRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return foundUser;
    }
}