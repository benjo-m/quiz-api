package com.example.quizapi.service;

import com.example.quizapi.models.Answer;
import com.example.quizapi.models.Question;
import com.example.quizapi.repository.AnswerRepository;
import com.example.quizapi.repository.QuestionRepository;
import com.example.quizapi.request.QuestionRequest;
import com.example.quizapi.response.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Value("${MIN_QUESTIONS}")
    private Integer MIN_QUESTIONS;

    @Value("${MAX_QUESTIONS}")
    private Integer MAX_QUESTIONS;

    @Value("${DIFFICULTY_LIST}")
    private List<String> DIFFICULTY_LIST;

    @Value("${CATEGORY_LIST}")
    private List<String> CATEGORY_LIST;

    public QuizService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public CategoryResponse getCategoryList() {
        return new CategoryResponse(CATEGORY_LIST);
    }

    public DifficultyResponse getDifficultyList() {
        return new DifficultyResponse(DIFFICULTY_LIST);
    }

    public Optional<QuestionFullResponse> getQuestions(String category, String difficulty, Integer amount) {
        if (amount < MIN_QUESTIONS || amount > MAX_QUESTIONS || !isValidCategory(category)
                || !isValidDifficulty(difficulty)) {
            return Optional.empty();
        }

        List<Question> questions = getQuestionList(category, difficulty, amount);
        List<QuestionResposne> questionResposneList = new ArrayList<>();

        for (Question q : questions) {
            List<Answer> answers = answerRepository.findAllByQuestion_Id(q.getId());
            List<String> texts = answers.stream().map(Answer::getText).toList();
            questionResposneList.add(new QuestionResposne(q, texts));
        }

        return Optional.of(new QuestionFullResponse(questionResposneList));
    }

    private List<Question> getQuestionList(String category, String difficulty, Integer amount) {
        List<Question> questions;
        if (category != null && difficulty != null) {
            questions = questionRepository.findByCategoryAndDifficulty(category, difficulty, amount);
        } else if (category != null) {
            questions = questionRepository.findByCategory(category, amount);
        } else if (difficulty != null) {
            questions = questionRepository.findByDifficulty(difficulty, amount);
        } else {
            questions = questionRepository.findAllQuestions(amount);
        }
        return questions;
    }

    public Optional<QuestionResposne> submitQuestion(QuestionRequest questionRequest) {
        if (isValidQuestionRequest(questionRequest)) {
            return Optional.empty();
        }

        Question question = new Question(questionRequest);

        questionRepository.save(question);

        for (String s : questionRequest.getIncorrectAnswers()) {
            Answer answer = new Answer(s, question);
            answerRepository.save(answer);
        }

        return Optional.of(new QuestionResposne(questionRequest));
    }

    private boolean isValidCategory(String category) {
        return CATEGORY_LIST.contains(category) || category == null;
    }

    private boolean isValidDifficulty(String difficulty) {
        return DIFFICULTY_LIST.contains(difficulty) || difficulty == null;
    }

    private boolean isValidQuestionRequest(QuestionRequest questionRequest) {
        return questionRequest.getQuestion() != null
            && !questionRequest.getQuestion().isBlank()
            && isValidDifficulty(questionRequest.getDifficulty())
            && isValidCategory(questionRequest.getCategory())
            && questionRequest.getCorrectAnswer() != null
            && !questionRequest.getCorrectAnswer().isBlank()
            && !questionRequest.getIncorrectAnswers().isEmpty();
    }
}
