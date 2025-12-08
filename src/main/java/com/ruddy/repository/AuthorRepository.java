package com.ruddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruddy.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {}

