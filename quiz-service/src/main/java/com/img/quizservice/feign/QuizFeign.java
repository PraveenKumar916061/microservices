package com.img.quizservice.feign;

import com.img.quizservice.model.QuestionWrapper;
import com.img.quizservice.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizFeign {

    @GetMapping("/question/generate")
    public ResponseEntity<List<Long>> getQuestionForQuiz(@RequestParam String category, @RequestParam int numQ);

    @PostMapping("/question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionForId(@RequestBody List<Long> questionIds);

    @PostMapping("/question/get-score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
