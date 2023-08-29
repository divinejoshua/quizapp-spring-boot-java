package com.divinejoshua.quizapp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")  //Parent routing
public class QuestionController {

    //Get all questions
    @GetMapping("allquestions")
    public String getAllQuestions(){
        return "These are all the questions";
    }
}
