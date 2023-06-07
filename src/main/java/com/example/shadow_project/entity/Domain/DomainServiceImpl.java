package com.example.shadow_project.entity.Domain;

import com.example.shadow_project.entity.Project.Project;
import com.example.shadow_project.entity.Project.ProjectRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class DomainServiceImpl implements DomainService{
    @Autowired
    DomainRepo domainRepo;
    @Autowired
    ProjectRepo projectRepo;


    @Override
    public Domain updateDomain() {
        return null;
    }

    @Override
    public List<Domain> allDomains() {
        return null;
    }

    @Override
    public List<Project> allProjectsInDomain() {
        return null;
    }

    @Override
    public List<Project> searchProjectInDomain() {
        return null;
    }
}
