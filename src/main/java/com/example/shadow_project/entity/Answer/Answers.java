package com.example.shadow_project.entity.Answer;

import com.example.shadow_project.entity.User.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Embeddable
@Table(name = "answers")
@Data
public class Answers {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "answer")
    private String answer;
    @OneToOne
    @Column(name = "replier_id")
    private User replier;
    @CreationTimestamp
    @Column(name = "answer_uploadedOn")
    private Date uploadedOn;
}
