package com.ruddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruddy.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {}
