package com.divinejoshua.quizapp.service;

import com.divinejoshua.quizapp.repository.QuestionRepository;
import com.divinejoshua.quizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

//    Question Data Access Object
    @Autowired
QuestionRepository questionRepository;


//    Get all questions
    public List<QuestionModel> getAllQuestions(){
        return questionRepository.findAll();
    }


//    Get questions by category
    public List<QuestionModel> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

//    Add new question and save
    public QuestionModel addQuestion(QuestionModel question) {
//        questionRepository.save(question);
        return question;
    }
}
