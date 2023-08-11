package com.example.quizapi.controller;

import com.example.quizapi.models.Answer;
import com.example.quizapi.request.QuestionRequest;
import com.example.quizapi.response.CategoryResponse;
import com.example.quizapi.response.DifficultyResponse;
import com.example.quizapi.response.QuestionFullResponse;
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
    public CategoryResponse getCategories() {
        return quizService.getCategoryList();
    }

    @GetMapping("/difficulty")
    public DifficultyResponse getDifficultyList() {
        return quizService.getDifficultyList();
    }

    @GetMapping("/answers")
    public List<Answer> getAllAnswers() {
        return quizService.getAllAnswers();
    }

    @GetMapping("/questions")
    public QuestionFullResponse getQuestionsByDifficulty() {
        return quizService.getQuestions();
    }

    @PostMapping("/questions")
    public void submitQuestion(@RequestBody QuestionRequest questionRequest) {
        quizService.submitQuestion(questionRequest);
    }
}
