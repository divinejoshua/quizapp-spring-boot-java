package com.divinejoshua.quizapp.service;

import com.divinejoshua.quizapp.repository.QuestionRepository;
import com.divinejoshua.quizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

//    Question Data Access Object
    @Autowired
QuestionRepository questionRepository;


//    Get all questions
    public ResponseEntity<List<QuestionModel>> getAllQuestions(){
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

        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception error){
            //Error handler
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


//Add new question and save
    public QuestionModel addQuestion(QuestionModel question) {
//        questionRepository.save(question);
        return question;
    }


//    Update Question
    public ResponseEntity<QuestionModel> UpdateQuestion(QuestionModel question) {

        Integer id;

        try {
            id = question.getId(); //Get the id of the question
//            if(id==null){
//                throw new Exception("Id is null");
//            }

            QuestionModel questionInstance = questionRepository.findById(id).get();

            if(questionInstance.getId() >0){
                System.out.println("Instance "+questionInstance.getId());
            } else {
                throw new Exception("Id is null");
            }



//        Set the new updates
            questionInstance.setQuestionTitle(question.getQuestionTitle());
            questionInstance.setOption1(question.getOption1());
            questionInstance.setOption2(question.getOption2());
            questionInstance.setOption3(question.getOption3());
            questionInstance.setRightAnswer(question.getRightAnswer());
            questionInstance.setCategory(question.getCategory());
            questionInstance.setDifficultylevel(question.getDifficultylevel());

            //        questionRepository.
            return new ResponseEntity<>(HttpStatus.OK);

        }
        catch (Exception error){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }
}
