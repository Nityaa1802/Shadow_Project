package com.example.shadow_project.entity.User;

import com.example.shadow_project.entity.Project.Project;
import lombok.Data;

import java.util.*;


@Data
public class UserResponse {

    private Long userId;

    private String userName;

    private String name;

    private String email;

    private List<String> skills=new ArrayList<>();

    private  String linkedIn;

    private String img;

    private List<Project> projects;
}
