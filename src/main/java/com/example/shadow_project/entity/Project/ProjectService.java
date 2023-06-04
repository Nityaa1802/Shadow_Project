package com.example.shadow_project.entity.Project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProjectService {

    Project uploadProject(ProjectDto projectDto);

    Project getProject(Long id);

    Project updateProject(Long id,ProjectDto projectDto);

    Project addTeamMember(Long teamLeadId,String teamMemberUserName,String Role,Long ProjectId);

    Project removeTeamMember(Long teamLeadId,String teamMemberUserName,Long ProjectId);

//    Project getProjectByTeamMember(String userName);

    List<Project> getCompletedProject(int pageNumber,int pageSize);

    Map<String,List<Project>> getProjectByUser(String userName);
}
