package com.divinejoshua.quizapp.service;

import com.divinejoshua.quizapp.repository.QuestionRepository;
import com.divinejoshua.quizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class QuestionService {

//    Question Data Access Object
    @Autowired
QuestionRepository questionRepository;


//    Get all questions
    public ResponseEntity<List<QuestionModel>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionRepository.findAll(Sort.by(Sort.Direction.ASC, "id")), HttpStatus.OK);
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
        questionRepository.save(question);
        return question;
    }


//    Update Question
    public ResponseEntity UpdateQuestion(QuestionModel question) {

        Integer id;
        QuestionModel questionInstance;
        HashMap<String, String> context = new HashMap<String, String>(); //Context response


        try {
            id = question.getId(); //Get the id of the question
            questionInstance = questionRepository.findById(id).orElseThrow(() -> new Exception("Question not found with ID" ));

        }
        catch (Exception error){
            context.put("message", "Invalid Id"); //Error message
            return new ResponseEntity<>(context, HttpStatus.BAD_REQUEST);
        }



        // Set the new updates
        questionInstance.setQuestionTitle(question.getQuestionTitle());
        questionInstance.setOption1(question.getOption1());
        questionInstance.setOption2(question.getOption2());
        questionInstance.setOption3(question.getOption3());
        questionInstance.setRightAnswer(question.getRightAnswer());
        questionInstance.setCategory(question.getCategory());
        questionInstance.setDifficultylevel(question.getDifficultylevel());

        questionRepository.save(questionInstance);
        context.put("message", "success"); //Success message

        return new ResponseEntity<>(context, HttpStatus.OK);


    }

//    Delete Question
    public ResponseEntity deleteQuestion(Integer id) {
        HashMap<String, String> context = new HashMap<String, String>(); //Context response

        try{
            questionRepository.findById(id).orElseThrow(() -> new Exception("Question not found with ID" )); //Get the id ot throw error
            questionRepository.deleteById(id); //Delete the Question
            context.put("message", "success"); //Success message
        }
        catch (Exception error){
            context.put("message", "Invalid Id"); //Error message
            return new ResponseEntity<>(context, HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(context, HttpStatus.OK);
    }
}
