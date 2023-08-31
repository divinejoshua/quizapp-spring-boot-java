package com.divinejoshua.quizapp.service;

import com.divinejoshua.quizapp.dao.QuestionDao;
import com.divinejoshua.quizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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


//    Get questions by category
    public List<QuestionModel> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

//    Add new question and save
    public QuestionModel addQuestion(QuestionModel question) {
//        questionDao.save(question);
        return question;
    }
}
