package com.example.shadow_project.entity.Answer;

import com.example.shadow_project.entity.User.User;
import lombok.Data;

@Data
public class AnswersDto {

    private String answer;

    private User replier;
}
