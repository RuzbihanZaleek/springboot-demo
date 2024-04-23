package com.example.quizApp.service;

import com.example.quizApp.dto.QuestionDTO;
import com.example.quizApp.entity.Question;
import com.example.quizApp.entity.Quiz;
import com.example.quizApp.repo.QuestionRepo;
import com.example.quizApp.repo.QuizRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    ModelMapper modelMapper;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
