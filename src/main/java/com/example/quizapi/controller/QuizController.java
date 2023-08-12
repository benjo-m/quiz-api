package com.example.quizapi.controller;

import com.example.quizapi.request.QuestionRequest;
import com.example.quizapi.response.CategoryResponse;
import com.example.quizapi.response.DifficultyResponse;
import com.example.quizapi.response.QuestionFullResponse;
import com.example.quizapi.response.QuestionResposne;
import com.example.quizapi.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/questions")
    public ResponseEntity<QuestionFullResponse> getQuestions(@RequestParam(required = false) String category,
                                             @RequestParam(required = false) String difficulty,
                                             @RequestParam(required = false, defaultValue = "5") Integer amount) {

        Optional<QuestionFullResponse> questionsOptional = quizService.getQuestions(category, difficulty, amount);

        if (questionsOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(questionsOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/submit-question")
    public ResponseEntity<QuestionResposne> submitQuestion(@RequestBody QuestionRequest questionRequest) {
        Optional<QuestionResposne> question = quizService.submitQuestion(questionRequest);

        if (question.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(question.get(), HttpStatus.OK);
    }
}
