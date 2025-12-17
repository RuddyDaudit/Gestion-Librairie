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
    // Si l'ID existe, on traite ça comme une modification
    if (book.getIdBook() != null && bookRepository.existsById(book.getIdBook())) {
        // On récupère le livre existant en base de données
        Book existingBook = bookRepository.findById(book.getIdBook()).get();
        
        // On met à jour les champs avec les nouvelles valeurs du formulaire
        existingBook.setNameBook(book.getNameBook());
        existingBook.setAuthorFirstName(book.getAuthorFirstName());
        existingBook.setAuthorLastName(book.getAuthorLastName());
        existingBook.setReleaseDate(book.getReleaseDate());
        existingBook.setPrice(book.getPrice());
        existingBook.setOrderStatus(book.getOrderStatus());
        
        // On ne régénère la photo que si le nom a changé (optionnel)
        existingBook.setImageUrl(genererLienPhoto(book.getNameBook()));
        
        return bookRepository.save(existingBook);
    } else {
        // Si pas d'ID, c'est une création pure
        book.setImageUrl(genererLienPhoto(book.getNameBook()));
        return bookRepository.save(book);
    }
}

    // Ta logique de photo déplacée ici (plus propre)
    private String genererLienPhoto(String name) {
        if (name == null || name.isEmpty()) {
            return "https://via.placeholder.com/150x200.png?text=Pas+de+titre";
        }
        
        // On nettoie le titre pour l'URL
        String query = name.trim().replace(" ", "%20");
        
        // URL Open Library par TITRE (M = Medium)
        // C'est très efficace : ils cherchent le livre le plus populaire avec ce nom
        return "https://covers.openlibrary.org/b/title/" + query + "-M.jpg";
    }
}