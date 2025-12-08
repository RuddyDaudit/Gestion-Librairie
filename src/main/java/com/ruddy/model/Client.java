package com.ruddy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idClient;
    String firstName;
    String lastName;
    int age;
    String mail;

    public Client(){}

    public Client(int idClient, String firstName, String lastName, int age, String mail) {
        this.idClient = idClient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
    }
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getFirstNameClient(){
        return this.firstName;
    }

    public void setLastNameClient(String lastName){
        this.lastName = lastName;
    }

    public String setLastNameClient(){
        return this.lastName;
    }

    public int getAgeClient(){
        return this.age;
    }

    public void setAgeClient(int age){
        this.age = age;
    }

    public String getMailClient(){
        return this.mail;
    }

    public void setMailClient(String mail){
        this.mail = mail;
    }

}
