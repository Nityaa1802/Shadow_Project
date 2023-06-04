package com.example.shadow_project.entity.User;

import com.example.shadow_project.entity.Project.Project;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Entity
@Table(name = "user")
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor

public class User {

    @Id
    @Column(name ="userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "userName", length =20,unique = true )
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @ElementCollection
    @CollectionTable(name = "skills_table",joinColumns =@JoinColumn(name = "userId"))
    @Column(name = "skills")
    private List<String> skills=new ArrayList<>();

    @Column(name = "linkedIn")
    private String linkedIn;

    @Column(name = "img")
    private String img;

    @ManyToMany
    private List<Project> projects=new ArrayList<>();

}
