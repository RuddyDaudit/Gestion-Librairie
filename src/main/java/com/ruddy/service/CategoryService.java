package com.ruddy.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruddy.model.Category;
import com.ruddy.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired 
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory() { 
        return categoryRepository.findAll(); 
    }
}