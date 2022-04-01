package com.example.agileup.service;

import com.example.agileup.Models.Personne;
import org.springframework.stereotype.Service;

@Service
public interface PersonneService {
    Personne findByMail(String mail);
}
