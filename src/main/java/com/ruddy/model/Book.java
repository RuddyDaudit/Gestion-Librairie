package com.ruddy.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Import nécessaire pour la date

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook; // ID du livre (auto-incrémentation)
    
    @Column(name = "name_book", nullable = false)
    private String nameBook; // Nom du livre
    
    // --- NOUVEAUX CHAMPS SIMPLIFIÉS ---
    
    @Column(name = "author_last_name")
    private String authorLastName; // Nom de l'auteur (String temporaire)
    
    @Column(name = "author_first_name")
    private String authorFirstName; // Prénom de l'auteur (String temporaire)
    
    @Column(name = "release_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate; // Date de sortie (Utilisation de LocalDate)
    
    private Double price; // Prix (Utilisation de Double)
    
    @Column(name = "image_couverture")
    private String imageUrl; //Image Url du livre

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // État de la commande (Utilisation d'une Enum)
    
    // --- Anciennes relations (Commentées pour simplification) ---
    /*
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author authorBook;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    */

    // Constructeur par défaut requis par JPA
    public Book(){}

    // Constructeur complet mis à jour
    public Book(Integer idBook, String nameBook, String authorLastName, String authorFirstName, LocalDate releaseDate, Double price, String imageUrl, OrderStatus orderStatus) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
        this.releaseDate = releaseDate;
        this.price = price;
        this.imageUrl = imageUrl;
        this.orderStatus = orderStatus;
    }

    // --- Getters et Setters (Mis à jour pour les nouveaux champs) ---

    public Integer getIdBook() { return idBook; }
    public void setIdBook(Integer idBook) {this.idBook = idBook;}
    
    public String getNameBook() { return nameBook; }
    public void setNameBook(String nameBook) { this.nameBook = nameBook; }

    public String getAuthorLastName() { return authorLastName; }
    public void setAuthorLastName(String authorLastName) { this.authorLastName = authorLastName; }

    public String getAuthorFirstName() { return authorFirstName; }
    public void setAuthorFirstName(String authorFirstName) { this.authorFirstName = authorFirstName; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getImageUrl(){return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public OrderStatus getOrderStatus() { return orderStatus; }
    public void setOrderStatus(OrderStatus orderStatus) { this.orderStatus = orderStatus; }

    // Les getters/setters pour Author et Category sont retirés/commentés
}