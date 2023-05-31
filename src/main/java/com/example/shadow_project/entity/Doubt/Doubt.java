package com.example.shadow_project.entity.Doubt;

import com.example.shadow_project.entity.Answer.Answers;
import com.example.shadow_project.entity.User.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doubt")
@Data
public class Doubt {
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "askedBy")
    private User askedBy;
    @Column(name = "question")
    private String question;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "doubts_answers", joinColumns = @JoinColumn(name = "doubt_id"))
    @Column(name = "answers")
    private Set<Answers> answersList;
    @CreationTimestamp
    @Column(name = "uploadedOn")
    private Date uploadedOn;

}
