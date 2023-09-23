package com.example.quizapi.repository;

import com.example.quizapi.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM questions ORDER BY RANDOM() LIMIT ?1")
    List<Question> findAllQuestions(Integer amount);

    @Query(nativeQuery = true, value = "SELECT * FROM questions where category LIKE lower(?1) AND difficulty LIKE lower(?2) ORDER BY RANDOM() LIMIT ?3")
    List<Question> findByCategoryAndDifficulty(String category, String difficulty, Integer amount);

    @Query(nativeQuery = true, value = "SELECT * FROM questions where difficulty LIKE lower(?1) ORDER BY RANDOM() LIMIT ?2")
    List<Question> findByDifficulty(String difficulty, Integer amount);

    @Query(nativeQuery = true, value = "SELECT * FROM questions where category LIKE lower(?1) ORDER BY RANDOM() LIMIT ?2")
    List<Question> findByCategory(String category, Integer amount);
}
