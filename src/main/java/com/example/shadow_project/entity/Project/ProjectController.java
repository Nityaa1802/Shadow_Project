package com.example.shadow_project.entity.Project;

import com.example.shadow_project.Payload.ApiResponse;
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

    @PutMapping("/addTeamMember/{projectId}")
    public ResponseEntity<ApiResponse> addTeamMember(@PathVariable("projectId")Long id, @RequestParam("teamLeadId") Long teamLeadId, @RequestParam("teamMemberUserName") String teamMemberUserName, @RequestParam("role") String role){

        Project project=this.projectService.addTeamMember(teamLeadId,teamMemberUserName,role,id);
        if(project!=null){
            return ResponseEntity.ok(new ApiResponse("success",true));
        }else{
           return ResponseEntity.ok(new ApiResponse("failed",false));

        }
    }

    @PutMapping("/removeTeamMember/{projectId}/{teamMemberUserName}")
    public ResponseEntity<ApiResponse> removeTeamMember(@PathVariable("projectId")Long id, @RequestParam("teamLeadId") Long teamLeadId, @PathVariable("teamMemberUserName") String teamMemberUserName){

        Project project=this.projectService.removeTeamMember(teamLeadId,teamMemberUserName,id);
        if(project!=null){
            return ResponseEntity.ok(new ApiResponse("success",true));
        }else{
            return ResponseEntity.ok(new ApiResponse("failed",false));

        }
    }
    
}
