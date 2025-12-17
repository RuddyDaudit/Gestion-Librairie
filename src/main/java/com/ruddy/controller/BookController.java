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

@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    // --- 1. AFFICHAGE DE LA LISTE ---
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("book", new Book()); 
        return "books"; 
    }
    
    // --- 2. AJOUT D'UN LIVRE ---
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        System.out.println("Ajout d'un nouveau livre : " + book.getNameBook());
        bookService.saveBook(book); 
        return "redirect:/books"; 
    }

    // --- 3. SUPPRESSION D'UN LIVRE ---
    @PostMapping("/delete")
    public String deleteBook(@RequestParam("bookIdToDelete") Integer id) { 
        System.out.println("Action suppression pour l'ID : " + id);
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    // --- 4. MODIFICATION D'UN LIVRE ---
    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") Book book, @RequestParam("idBook") Integer idBook) {
        // On force l'ID manuellement au cas où le @ModelAttribute aurait échoué
        book.setIdBook(idBook);
        
        System.out.println("FORCE ID >>> " + book.getIdBook());
        
        bookService.saveBook(book);
        return "redirect:/books";
    }
}