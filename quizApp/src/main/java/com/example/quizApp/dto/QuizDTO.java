package com.example.quizApp.dto;

import com.example.quizApp.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizDTO {
    private int id;
    private String title;
    private Question questions;
}
