package com.example.quizApp.service;

import com.example.quizApp.dto.QuestionDTO;
import com.example.quizApp.entity.Question;
import com.example.quizApp.repo.QuestionRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = questionRepo.findAll();
        return modelMapper.map(questions, new TypeToken<List<QuestionDTO>>() {
        }.getType());
    }

    public List<QuestionDTO> getQuestionsByCategory(String category) {
        List<Question> questions = questionRepo.findByCategory(category);
        return modelMapper.map(questions, new TypeToken<List<QuestionDTO>>() {
        }.getType());
    }

    public String addQuestion(QuestionDTO question) {
        questionRepo.save(modelMapper.map(question, Question.class));
        return "Success";
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
