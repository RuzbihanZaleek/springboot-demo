package com.example.quizApp.repo;

import com.example.quizApp.entity.Question;
import com.example.quizApp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
