package com.example.quizapi.controller;

import com.example.quizapi.models.Category;
import com.example.quizapi.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz-api")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return quizService.getCategories();
    }

    // GET QUESTIONS

    // POST QUESTION
}
