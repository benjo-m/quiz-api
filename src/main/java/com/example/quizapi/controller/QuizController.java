package com.example.quizapi.controller;

import com.example.quizapi.exception.InvalidRequestException;
import com.example.quizapi.request.QuestionRequest;
import com.example.quizapi.response.*;
import com.example.quizapi.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/quiz-api")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimeStamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/category")
    public CategoryResponse getCategories() {
        return quizService.getCategoryList();
    }

    @GetMapping("/difficulty")
    public DifficultyResponse getDifficultyList() {
        return quizService.getDifficultyList();
    }

    @GetMapping("/questions")
    public ResponseEntity<QuestionFullResponse> getQuestions(
        @RequestParam(required = false) String category,
        @RequestParam(required = false) String difficulty,
        @RequestParam(required = false, defaultValue = "5") Integer amount) {

        Optional<QuestionFullResponse> questionsOptional = quizService.getQuestions(category, difficulty, amount);

        if (questionsOptional.isEmpty()) {
            throw new InvalidRequestException("Invalid category / difficulty / amount (min=5, max=20)");
        }

        return new ResponseEntity<>(questionsOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/questions")
    public ResponseEntity<QuestionResposne> submitQuestion(@RequestBody QuestionRequest questionRequest) {
        Optional<QuestionResposne> question = quizService.submitQuestion(questionRequest);

        if (question.isEmpty()) {
            throw new InvalidRequestException("Invalid question structure");
        }

        return new ResponseEntity<>(question.get(), HttpStatus.OK);
    }
}
