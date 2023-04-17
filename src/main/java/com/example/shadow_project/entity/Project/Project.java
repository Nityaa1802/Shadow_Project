package com.example.shadow_project.entity.Project;

import com.example.shadow_project.entity.User.User;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "projectName")
    private String projectName;

    @Column(name = "description")
    private String description;

    @Column(name = "github")
    private String github;

    @Column(name = "portfolio")
    private String portfolio;

    @Column(name = "report")
    private String report;

    @Column(name = "startedDate")
    private Date startedDate;

    @ManyToOne
    private User teamLead;

    @Column(name = "isCompleted")
    private boolean isCompleted;

    @Column(name = "img")
    private String img;

    @ManyToMany
    private List<User> teamMembers;

}
