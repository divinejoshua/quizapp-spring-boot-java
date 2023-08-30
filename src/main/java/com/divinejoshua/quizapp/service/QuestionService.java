package com.divinejoshua.quizapp.service;

import com.divinejoshua.quizapp.dao.QuestionDao;
import com.divinejoshua.quizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

//    Question Data Access Object
    @Autowired
    QuestionDao questionDao;


//    Get all questions
    public List<QuestionModel> getAllQuestions(){
        return questionDao.findAll();
    }
}
