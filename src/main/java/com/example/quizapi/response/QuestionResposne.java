package com.example.quizapi.response;

import com.example.quizapi.models.Question;

import java.util.List;

public class QuestionResposne {
    private String question;
    private String difficulty;
    private String category;
    private String correctAnswer;
    private List<String> incorrectAnswers;

    public QuestionResposne(Question question, List<String> incorrectAnswers) {
        this.question = question.getText();
        this.difficulty = question.getDifficulty().toLowerCase();
        this.category = question.getCategory().toLowerCase();
        this.correctAnswer = question.getCorrectAnswer();
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

    public QuestionResposne(String question, String difficulty, String category, String correctAnswer, List<String> incorrectAnswers) {
        this.question = question;
        this.difficulty = difficulty;
        this.category = category;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public QuestionResposne() {
    }
}
