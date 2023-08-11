package com.example.quizapi.models;

import com.example.quizapi.request.QuestionRequest;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "questions", schema = "public")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String text;
    private String difficulty;
    private String category;
    private String correctAnswer;

    public Question() {
    }

    public Question(QuestionRequest questionRequest) {
        this.text = questionRequest.getQuestion();
        this.difficulty = questionRequest.getDifficulty();
        this.category = questionRequest.getCategory();
        this.correctAnswer = questionRequest.getCorrectAnswer();
    }

    public Question(UUID id, String text, String difficulty, String category, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.difficulty = difficulty;
        this.category = category;
        this.correctAnswer = correctAnswer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
