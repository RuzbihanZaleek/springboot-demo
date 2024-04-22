package com.example.quizApp.controller;

import com.example.quizApp.dto.QuestionDTO;
import com.example.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "/allQuestions")
    public List<QuestionDTO> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}
