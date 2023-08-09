package com.example.quizapi.service;

import com.example.quizapi.models.Category;
import com.example.quizapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final CategoryRepository categoryRepository;

    public QuizService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
