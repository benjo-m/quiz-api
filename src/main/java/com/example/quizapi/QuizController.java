package com.example.quizapi;

import com.example.quizapi.exception.InvalidRequestException;
import com.example.quizapi.request.QuestionRequest;
import com.example.quizapi.response.*;
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

    @GetMapping("/category")
    public CategoryResponse getCategories() {
        return quizService.getCategoryList();
    }

    @GetMapping("/difficulty")
    public DifficultyResponse getDifficultyList() {
        return quizService.getDifficultyList();
    }

    @GetMapping("/questions")
    public ResponseEntity<QuestionListResponse> getQuestions(
        @RequestParam(required = false) String category,
        @RequestParam(required = false) String difficulty,
        @RequestParam(required = false, defaultValue = "5") Integer amount) {

        Optional<QuestionListResponse> questionsOptional = quizService.getQuestions(category, difficulty, amount);

        if (questionsOptional.isEmpty()) {
            throw new InvalidRequestException("Invalid category, difficulty, or amount");
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
