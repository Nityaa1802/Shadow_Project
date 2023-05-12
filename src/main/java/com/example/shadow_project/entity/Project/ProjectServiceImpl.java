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
    public ProjectDto uploadProject(ProjectDto projectDto) {

        modelMapper.typeMap(ProjectDto.class, Project.class).addMappings(
                mapper-> mapper.map(projectDto1->userRepo.findUserByUserName(projectDto.getTeamLead()),Project::setTeamLead)
        );

        Project project = modelMapper.map(projectDto,Project.class);
        Project savedProject=projectRepo.save(project);

        ProjectDto savedProjectDto = modelMapper.map(savedProject, ProjectDto.class);
        return savedProjectDto;

    }



}
