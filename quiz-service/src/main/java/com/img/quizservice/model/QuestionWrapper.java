package com.img.quizservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionWrapper {

    private Long id;
    private String questionTitle;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;

    public QuestionWrapper(Long id, String questionTitle, String opt1, String opt2, String opt3, String opt4) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
    }
}


