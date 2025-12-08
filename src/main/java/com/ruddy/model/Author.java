package com.ruddy.model;

import jakarta.persistence.Column; // Ajouté pour bonne pratique
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuthor; // Correction: Utilisation de Integer (meilleure pratique JPA)
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    private String description; // Pas besoin de @Column si le nom correspond

    // Constructeur par défaut requis par JPA
    public Author(){}
    
    // Constructeur complet (ID est maintenant Integer)
    public Author(Integer idAuthor, String firstName, String lastName, String description){
        this.idAuthor = idAuthor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    // --- Getters et Setters (Standard Java) ---

    public Integer getIdAuthor(){
        return this.idAuthor;
    }

    // Le getter doit s'appeler getFirstName, pas getFirstnameAuthor
    public String getFirstName(){ 
        return this.firstName;
    }

    // Le setter doit s'appeler setFirstName, pas setFirstNameAuthor
    public void setFirstName(String firstName){ 
        this.firstName = firstName;
    }

    // Le getter doit s'appeler getLastName, pas getLastNameAuthor
    public String getLastName(){
        return this.lastName;
    }

    // Le setter doit s'appeler setLastName, pas setLastNameAuthor
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    // Le getter doit s'appeler getDescription, pas getDescriptionAuthor
    public String getDescription(){
        return this.description;
    }

    // Le setter doit s'appeler setDescription, pas setDescriptionAuthor
    public void setDescription(String description){
        this.description = description;
    }
    
    // Pas de setter pour l'ID car il est auto-généré
}