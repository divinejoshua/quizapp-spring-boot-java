package com.divinejoshua.quizapp.service;

import com.divinejoshua.quizapp.repository.QuestionRepository;
import com.divinejoshua.quizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

//    Question Data Access Object
    @Autowired
QuestionRepository questionRepository;


//    Get all questions
    public ResponseEntity<List<QuestionModel>> getAllQuestions(){

//        Exception handler
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception error){
            //Error handler
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


//    Get questions by category
    public ResponseEntity<List<QuestionModel>> getQuestionsByCategory(String category) {

//        Exception handler
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception error){
            //Error handler
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

//    Add new question and save
    public QuestionModel addQuestion(QuestionModel question) {
//        questionRepository.save(question);
        return question;
    }

//    Update Question
    public QuestionModel UpdateQuestion(QuestionModel question) {
        return question;
    }
}
