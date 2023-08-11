package com.example.quizapi.repository;

import com.example.quizapi.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findAllByQuestion_Id(UUID questionId);
}
