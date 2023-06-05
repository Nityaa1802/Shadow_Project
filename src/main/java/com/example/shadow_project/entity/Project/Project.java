package com.example.shadow_project.entity.Project;

import com.example.shadow_project.entity.TeamMember.TeamMember;
import com.example.shadow_project.entity.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
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

    @JsonBackReference
    @ManyToOne
    private User teamLead;

    @Column(name = "isCompleted")
    private boolean isCompleted;

    @Column(name = "img")
    private String img;

    @JsonBackReference
    @ElementCollection(fetch = FetchType.EAGER )
    @CollectionTable(name ="Team_Members",joinColumns = @JoinColumn(name = "projectId"))
    private Set<TeamMember> teamMembers=new HashSet<>();

}
