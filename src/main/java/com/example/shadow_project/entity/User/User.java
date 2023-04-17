package com.example.shadow_project.entity.User;

import com.example.shadow_project.entity.Project.Project;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @Column(name = "userName", length =20 )
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "qualifications")
    private String qualifications;

    @Column(name = "linkedIn")
    private String linkedIn;

    @Column(name = "img")
    private String img;

    @ManyToMany
    private List<Project> projects;



}
