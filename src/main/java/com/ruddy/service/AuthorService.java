package com.ruddy.service;

import java.util.List; // ⬅️ MANQUANT : Nécessaire pour retourner une liste

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruddy.model.Author;
import com.ruddy.repository.AuthorRepository; // ⬅️ MANQUANT : Nécessaire pour le type de retour

@Service
public class AuthorService {
    
    @Autowired 
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthor() { // Nom de la méthode standardisé à find/findAll
        return authorRepository.findAll(); 
    }
}