package com.img.quizservice.service;

import com.img.quizservice.dao.QuizRepository;
import com.img.quizservice.feign.QuizFeign;
import com.img.quizservice.model.QuestionWrapper;
import com.img.quizservice.model.Quiz;
import com.img.quizservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizFeign quizFeign;

    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
        List<Long> questions = quizFeign.getQuestionForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success..", HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Long id) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Long> questionIds = quiz.getQuestionIds();
        return quizFeign.getQuestionForId(questionIds);
    }

    public ResponseEntity<Integer> calculateResult(Long id, List<Response> responses) {
        ResponseEntity<Integer> score = quizFeign.getScore(responses);
        return score;
    }
}
