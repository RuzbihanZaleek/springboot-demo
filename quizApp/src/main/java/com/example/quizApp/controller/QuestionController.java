package com.example.quizApp.controller;

import com.example.quizApp.dto.QuestionDTO;
import com.example.quizApp.entity.Question;
import com.example.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping(value = "allQuestions")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping(value = "getQuestionsByCategory/{category}")
    public ResponseEntity<List<QuestionDTO>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping(value = "addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionDTO question) {
        return questionService.addQuestion(question);
    }

    @PutMapping(value = "updateQuestion")
    public String updateQuestion(@RequestBody QuestionDTO question) {
        return questionService.updateQuestion(question);
    }

    @DeleteMapping(value = "deleteQuestion")
    public String deleteQuestion(@RequestBody QuestionDTO question) {
        return  questionService.deleteQuestion(question);
    }
}
