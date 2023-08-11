package com.example.quizapi.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "answers", schema = "public")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String text;
    @ManyToOne
    private Question question;

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer(UUID id, String text, Question question) {
        this.id = id;
        this.text = text;
        this.question = question;
    }

    public Answer(String text, Question question) {
        this.text = text;
        this.question = question;
    }
    public Answer() {
    }
}
