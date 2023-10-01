package com.example.quizapi.model;

import com.example.quizapi.request.QuestionRequest;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "questions", schema = "public")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "text")
    private String text;
    @Column(name = "difficulty")
    private String difficulty;
    @Column(name = "category")
    private String category;
    @Column(name = "correct_answer")
    private String correctAnswer;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> incorrectAnswers;

    public Question() {
    }

    public Question(QuestionRequest questionRequest) {
        this.text = questionRequest.getQuestion();
        this.difficulty = questionRequest.getDifficulty();
        this.category = questionRequest.getCategory();
        this.correctAnswer = questionRequest.getCorrectAnswer();
    }

    public Question(Integer id, String text, String difficulty, String category, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.difficulty = difficulty;
        this.category = category;
        this.correctAnswer = correctAnswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Answer> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(List<Answer> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
}
