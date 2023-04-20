package com.example.shadow_project.entity.Project;

import com.example.shadow_project.entity.User.User;
import lombok.Data;

import java.sql.Date;

@Data
public class ProjectDto {

    private String projectName;

    private String description;

    private String github;

    private String teamLead;
}
