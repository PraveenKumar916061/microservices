package com.img.quizservice.controller;

import com.img.quizservice.model.QuestionWrapper;
import com.img.quizservice.model.QuizDTO;
import com.img.quizservice.model.Response;
import com.img.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create-quiz")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
        return quizService.createQuiz(quizDTO.getCategory(),quizDTO.getNumQuestions(),quizDTO.getTitle());
    }

    @GetMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Long id,@RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Long id){
        return quizService.getQuizQuestions(id);
    }
}
