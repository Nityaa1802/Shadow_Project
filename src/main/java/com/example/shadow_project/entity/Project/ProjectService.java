package com.example.shadow_project.entity.Project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    ProjectDto uploadProject(ProjectDto projectDto);


}
