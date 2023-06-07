package com.example.shadow_project.entity.Domain;

import com.example.shadow_project.entity.Project.Project;

import java.util.List;

public interface DomainService {

    Domain updateDomain();
    List<Domain> allDomains();

    List<Project> allProjectsInDomain();

    List<Project> searchProjectInDomain();
}
