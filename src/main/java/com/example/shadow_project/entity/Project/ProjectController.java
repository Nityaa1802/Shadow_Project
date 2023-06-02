package com.example.shadow_project.entity.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @PostMapping("/register")
    public ResponseEntity<Project> registerProject(@RequestBody ProjectDto projectDto){
        Project savedProject=projectService.uploadProject(projectDto);
        return ResponseEntity.ok(savedProject);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId") Long id){
        Project project=this.projectService.getProject(id);
        return ResponseEntity.ok(project);
    }
    @PutMapping("/updateDetails/{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable("projectId")Long id,@RequestBody ProjectDto projectDto
    ){
        Project project=this.projectService.updateProject(id,projectDto);
        return ResponseEntity.ok(project);
    }
    
}
