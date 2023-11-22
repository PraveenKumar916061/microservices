package com.img.questionservice.controller;

import com.img.questionservice.model.Question;
import com.img.questionservice.model.QuestionWrapper;
import com.img.questionservice.model.Response;
import com.img.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private Environment environment;

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("/all-questions")
    public ResponseEntity<List<Question>> getQuestions() {
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCatgeory(@PathVariable("category") String category) {
        return questionService.getAllQuestionByCategory(category);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Long>> getQuestionForQuiz(@RequestParam String category, @RequestParam int numQ) {
        return questionService.getQuestionForQuiz(category, numQ);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionForId(@RequestBody List<Long> questionIds) {
        return questionService.getQuestionsForId(questionIds);
    }

    @PostMapping("/get-score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

}
