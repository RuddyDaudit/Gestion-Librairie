package com.ruddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ruddy.model.Book;
import com.ruddy.service.BookService;

// Les imports AuthorService et CategoryService sont retirés

@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    // --- Les injections AuthorService et CategoryService sont retirées ---
    /*
    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;
    */

    // --- 1. AFFICHAGE DES LISTES (GET /books) ---
    @GetMapping
    public String listBooks(Model model){
        // Récupère les données nécessaires
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("book", new Book()); // Objet vide pour le formulaire d'ajout
        
        // Les lignes pour authorService et categoryService sont retirées
        /*
        model.addAttribute("allAuthors", authorService.getAllAuthor()); 
        model.addAttribute("allCategories", categoryService.getAllCategory());
        */
        
        return "books"; // Vue Thymeleaf
    }
    
    // --- 2. AJOUT D'UN LIVRE (POST /books/add) ---
    @PostMapping("/add")
    public String addBook(
        @ModelAttribute Book book) // ⬅️ Les @RequestParam authorId et categoryId sont retirés
    {
        // Utilise la méthode du service simplifiée
        bookService.saveBook(book); // ⬅️ Utilisation de la nouvelle méthode saveBook
        return "redirect:/books"; // Redirection vers la page d'accueil
    }

    // --- 3. SUPPRESSION D'UN LIVRE (POST /books/delete) ---
    @PostMapping("/delete")
    public String deleteBook(@RequestParam("bookIdToDelete") Integer id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}