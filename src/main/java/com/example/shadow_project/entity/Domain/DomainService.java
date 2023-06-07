package com.example.shadow_project.entity.Domain;

import com.example.shadow_project.entity.Project.Project;

import java.util.List;

public interface DomainService {

    Domain uploadDomain(String domain , Long projectId);

    void updateDomain(List<String> domainsUploadedByUser , Long projectId);
    List<String> allDomains();

    List<Project> allProjectsInDomain(String domain) throws Exception;

    List<Project> searchProjectInDomain(String input);


}
