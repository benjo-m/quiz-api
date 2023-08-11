package com.example.quizapi.service;

import com.example.quizapi.Resources;
import com.example.quizapi.models.Answer;
import com.example.quizapi.models.Question;
import com.example.quizapi.repository.AnswerRepository;
import com.example.quizapi.repository.QuestionRepository;
import com.example.quizapi.request.QuestionRequest;
import com.example.quizapi.response.CategoryResponse;
import com.example.quizapi.response.DifficultyResponse;
import com.example.quizapi.response.QuestionFullResponse;
import com.example.quizapi.response.QuestionResposne;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public QuizService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public CategoryResponse getCategoryList() {
        return new CategoryResponse(Resources.categoryList);
    }

    public DifficultyResponse getDifficultyList() {
        return new DifficultyResponse(Resources.difficultyList);
    }

    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public QuestionFullResponse getQuestions() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionResposne> questionResposneList = new ArrayList<>();

        for (Question q : questions) {
            List<Answer> answers = answerRepository.findAllByQuestion_Id(q.getId());
            List<String> texts = answers.stream().map(Answer::getText).toList();
            questionResposneList.add(new QuestionResposne(q, texts));
        }

        return new QuestionFullResponse(questionResposneList);
    }

    public void submitQuestion(QuestionRequest questionRequest) {
        Question question = new Question(questionRequest);
        questionRepository.save(question);

        for (String s : questionRequest.getIncorrectAnswers()) {
            Answer answer = new Answer(s, question);
            answerRepository.save(answer);
        }
    }

}
