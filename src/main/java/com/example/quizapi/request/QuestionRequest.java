package com.example.quizapi.request;

import java.util.List;

public class QuestionRequest {
    private String question;
    private String difficulty;
    private String category;
    private String correctAnswer;
    private List<String> incorrectAnswers;

    public QuestionRequest() {
    }

    public QuestionRequest(String question, String difficulty, String category, String correctAnswer, List<String> incorrectAnswers) {
        this.question = question;
        this.difficulty = difficulty;
        this.category = category;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
}

//    {
//        "question": "What is the capital of Sweden?",
//        "difficulty": "easy",
//        "category": "geography",
//        "correctAnswer": "Stockholm",
//        "incorrectAnswers": [
//            "Copenhagen",
//            "Edinburgh",
//            "Helsinki"
//        ]
//    },
