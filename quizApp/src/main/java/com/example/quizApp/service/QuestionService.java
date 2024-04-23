package com.example.quizApp.service;

import com.example.quizApp.dto.QuestionDTO;
import com.example.quizApp.entity.Question;
import com.example.quizApp.repo.QuestionRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
        try {
            List<Question> questions = questionRepo.findAll();
            List<QuestionDTO> questionList = modelMapper.map(questions, new TypeToken<List<QuestionDTO>>() {
            }.getType());
            return new ResponseEntity<>(questionList, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionDTO>> getQuestionsByCategory(String category) {
        try {
            List<Question> questions = questionRepo.findByCategory(category);
            List<QuestionDTO> questionList = modelMapper.map(questions, new TypeToken<List<QuestionDTO>>() {
            }.getType());
            return new ResponseEntity<>(questionList, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(QuestionDTO question) {
        try {
            questionRepo.save(modelMapper.map(question, Question.class));
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
    }

    public String updateQuestion(QuestionDTO question) {
        questionRepo.save(modelMapper.map(question, Question.class));
        return "Success";
    }

    public String deleteQuestion(QuestionDTO question) {
        questionRepo.delete(modelMapper.map(question, Question.class));
        return "Question Deleted Successfully";
    }
}
