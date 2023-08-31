package com.divinejoshua.quizapp.dao;

import com.divinejoshua.quizapp.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionDao extends JpaRepository<QuestionModel, Integer> {

    List<QuestionModel> findByCategory(String category);
}
