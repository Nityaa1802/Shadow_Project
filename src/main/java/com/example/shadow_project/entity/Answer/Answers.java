package com.example.shadow_project.entity.Answer;

import com.example.shadow_project.entity.User.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Embeddable
@Data
public class Answers {


    private String answer;

    @OneToOne
    private User replier;


    private Date uploadedAns;
}
