package com.ruddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruddy.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {}
