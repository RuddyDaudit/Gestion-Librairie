package com.ruddy.librairy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // Pour le moment, rien n'est créé automatiquement
        System.out.println("DataLoader lancé. Aucun livre créé pour le moment.");
    }
}