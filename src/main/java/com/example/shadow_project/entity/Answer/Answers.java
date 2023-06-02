package com.example.shadow_project.entity.Answer;
import com.example.shadow_project.entity.User.User;
import jakarta.persistence.*;
import lombok.Data;



@Embeddable
@Data
public class Answers {

    private String answer;

    @OneToOne
    private User replier;

}
