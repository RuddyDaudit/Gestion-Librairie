package com.ruddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruddy.model.Book;
import com.ruddy.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired 
    private BookRepository bookRepository;

    // --- Les injections de AuthorRepository et CategoryRepository sont retirées ---
    /*
    @Autowired 
    private AuthorRepository authorRepository;
    
    @Autowired 
    private CategoryRepository categoryRepository;
    */
    
    // 1. Liste tous les livres (inchangé)
    public List<Book> getAllBooks() { 
        return bookRepository.findAll(); 
    }
    
    // 2. Supprime un livre (inchangé)
    public void deleteBook(Integer id) { 
        bookRepository.deleteById(id); 
    }

    // 3. Sauvegarde le livre (Méthode simplifiée)
    // L'ancienne méthode saveBookWithRelations est supprimée.
    public Book saveBook(Book book) {
        // Sauvegarde l'objet Book qui contient maintenant les champs String (Auteur, etc.)
        return bookRepository.save(book);
    }
}