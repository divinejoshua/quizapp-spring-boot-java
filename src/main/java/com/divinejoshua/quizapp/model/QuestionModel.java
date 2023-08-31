package com.divinejoshua.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//    NOTE:
//    Use camel casing for variable naming in Models and
//    it will auto convert to snake casing on the postgresql db


@Data
@Entity
public class QuestionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Question title is Compulsory")
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String rightAnswer;
    private String difficultylevel;
    private String category;

}
