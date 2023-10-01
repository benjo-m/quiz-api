package com.example.quizapi.response;

import java.util.List;

public class QuestionListResponse {
    private Integer numberOfQuestions;
    private List<QuestionResposne> questions;

    public QuestionListResponse() {
    }

    public QuestionListResponse(List<QuestionResposne> questions) {
        this.numberOfQuestions = questions.size();
        this.questions = questions;
    }

    public List<QuestionResposne> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionResposne> questions) {
        this.questions = questions;
    }

    public Integer getNumberOfQuestions() {
        return numberOfQuestions;
    }
}
