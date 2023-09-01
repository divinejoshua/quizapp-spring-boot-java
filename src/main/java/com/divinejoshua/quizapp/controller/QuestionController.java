package com.divinejoshua.quizapp.controller;
import com.divinejoshua.quizapp.model.QuestionModel;
import com.divinejoshua.quizapp.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("question")  //Parent routing
public class QuestionController {

    //    The question service
    @Autowired      //Auto wired: I don't need to use the 'New' keyword
    QuestionService questionService;

    //Get all questions
    @GetMapping("allquestions")
    public ResponseEntity<List<QuestionModel>> getAllQuestions(){
        return questionService.getAllQuestions();
    }


    //Get Question by Category
    @GetMapping("category/{category}")
    public List<QuestionModel> getQuestionById(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<HashMap<String, String>> addQuestions(@Valid @RequestBody QuestionModel question){
        HashMap<String, String> context = new HashMap<String, String>(); //Context response

        questionService.addQuestion(question); // Add question service
        context.put("message", "success"); //Success message


        return ResponseEntity.ok(context);
    }
}
