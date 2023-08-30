package com.divinejoshua.quizapp.controller;
import com.divinejoshua.quizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")  //Parent routing
public class QuestionController {

//    The question service
    @Autowired      //Auto wired is so I dont need to use the 'New' keyword
    QuestionService questionService;


    //Get all questions
    @GetMapping("allquestions")
    public List<QuestionModel> getAllQuestions(){
        return questionService.getAllQuestions;
    }
}
