package com.example.shadow_project.entity.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @PostMapping("/register/project")
    public ResponseEntity<ProjectDto> registerProject(@RequestBody ProjectDto projectDto){
        ProjectDto savedProjectDto=projectService.uploadProject(projectDto);
        return ResponseEntity.ok(savedProjectDto);
    }


}
