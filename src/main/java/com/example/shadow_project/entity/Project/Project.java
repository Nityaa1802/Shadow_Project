package com.example.shadow_project.entity.Project;

import com.example.shadow_project.entity.TeamMember.TeamMember;
import com.example.shadow_project.entity.User.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @CreationTimestamp
    @Column(name = "startedDate")
    private Date startedDate;

    @ManyToOne
    private User teamLead;

    @Column(name = "isCompleted")
    private boolean isCompleted;

    @Column(name = "img")
    private String img;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name ="Team_Members",joinColumns = @JoinColumn(name = "projectId"))
    private Set<TeamMember> teamMembers;

}
