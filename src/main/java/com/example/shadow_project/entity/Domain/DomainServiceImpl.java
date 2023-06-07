package com.example.shadow_project.entity.Domain;

import com.example.shadow_project.entity.Project.Project;
import com.example.shadow_project.entity.Project.ProjectRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class DomainServiceImpl implements DomainService{
    @Autowired
    DomainRepo domainRepo;
    @Autowired
    ProjectRepo projectRepo;


    @Override
    public Domain uploadDomain(String domain , Long projectId) {
        Domain newDomain = new Domain();
        newDomain.setDomain(domain);
        List<Long> projectInDomain = new ArrayList<>();
        projectInDomain.add(projectId);
        newDomain.setProjectsInDomain(projectInDomain);
        Domain response = domainRepo.save(newDomain);
        return response;
    }



    @Override
    public void updateDomain(List<String> domainsUploadedByUser , Long projectId) {
        for (String domain : domainsUploadedByUser) {
            Domain domain1 = domainRepo.getDomain(domain);

            // if the domain that the project has is not found in the domain table then we will upload a new domain
            if (domain1 == null) {
                uploadDomain(domain , projectId);
            }

            // if the domain is found
            else {
                if (domain1.getProjectsInDomain() == null) {
                    List<Long> projectInDomain = new ArrayList<>();
                    projectInDomain.add(projectId);
                    domain1.setProjectsInDomain(projectInDomain);
                } else {
                    List<Long> projectInDomain = domain1.getProjectsInDomain();
                    projectInDomain.add(projectId);
                    domain1.setProjectsInDomain(projectInDomain);
                }
                domainRepo.save(domain1);
            }
        }
    }

    @Override
    public List<Domain> allDomains() {
        return null;
    }

    @Override
    public List<Project> allProjectsInDomain(String domain) throws Exception {
        Domain domain1 = domainRepo.getDomain(domain);
        List<Project> response = new ArrayList<>();

        if(domain1.getProjectsInDomain()==null || domain1.getProjectsInDomain().size()==0){
            throw new Exception("There are no projects in this particular Domain");
        }
        for (Long pId : domain1.getProjectsInDomain()) {
            Project project = projectRepo.getById(pId);
            response.add(project);
        }

        return response;
    }

    @Override
    public List<Project> searchProjectInDomain() {
        return null;
    }
}
