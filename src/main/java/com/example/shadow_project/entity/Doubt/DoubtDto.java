package com.example.shadow_project.entity.Doubt;

import com.example.shadow_project.entity.Answer.Answers;
import com.example.shadow_project.entity.User.User;
import lombok.Data;

import java.util.Set;

@Data
public class DoubtDto {

    private String askedBy;
    private String question;
    private Set<Answers> answersList;
}
