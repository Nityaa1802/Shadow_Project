package com.example.shadow_project.entity.Project;

import com.example.shadow_project.entity.User.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.DestinationSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Project uploadProject(ProjectDto projectDto) {

        modelMapper.typeMap(ProjectDto.class, Project.class).addMappings(
                mapper-> mapper.map(projectDto1->userRepo.getUserByUserName(projectDto.getTeamLead()),Project::setTeamLead)
        );

        Project project = modelMapper.map(projectDto,Project.class);
        Project savedProject=projectRepo.save(project);


        return savedProject;

    }


    @Override
    public Project getProject(Long id) {
        Project project=this.projectRepo.getById(id);
        return project;
    }

    @Override
    public Project updateProject(Long id,ProjectDto projectDto) {
        Project project=this.projectRepo.getById(id);
        project.setProjectName(projectDto.getProjectName());
        project.setDescription(projectDto.getDescription());
        project.setGithub(projectDto.getGithub());
        project.setPortfolio(projectDto.getPortfolio());
        project.setReport(projectDto.getReport());
        this.projectRepo.save(project);
        return project;
    }
}
