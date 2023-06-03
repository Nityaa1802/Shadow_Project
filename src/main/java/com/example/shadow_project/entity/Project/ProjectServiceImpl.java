package com.example.shadow_project.entity.Project;

import com.example.shadow_project.entity.TeamMember.TeamMember;
import com.example.shadow_project.entity.User.User;
import com.example.shadow_project.entity.User.UserRepo;
import com.example.shadow_project.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.DestinationSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.print.attribute.standard.Destination;
import java.util.*;

@Service
@Transactional
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

    @Override
    public Project addTeamMember(Long teamLeadId, String teamMemberUserName, String role,Long projectId) {
        Project project=this.projectRepo.getById(projectId);
        if(project==null){
            throw new ResourceNotFoundException("Project","Project Id",String.valueOf(projectId));
        }
        if(project.getTeamLead().getUserId()!=teamLeadId){

           return null;

        }
         User user=this.userRepo.getUserByUserName(teamMemberUserName);
//        List<Project> projectList=user.getProjects();
//        if(projectList==null||projectList.size()==0){
//            projectList=new ArrayList<>();
//        }
//        projectList.add(project);
//        user.setProjects(projectList);
//        this.userRepo.save(user);
        TeamMember teamMember=new TeamMember(user,role);

        Set<TeamMember> teamMemberSet;
        if(project.getTeamMembers()==null || project.getTeamMembers().size()==0){
            teamMemberSet=new HashSet<>();
        }else {
            teamMemberSet=project.getTeamMembers();
            for (TeamMember teamMember1:teamMemberSet){
                if(teamMember1.getUser().getUserName()==teamMemberUserName||
                        project.getTeamLead().getUserName()==teamMemberUserName){

                    return null;

                }
            }
        }
        teamMemberSet.add(teamMember);

        project.setTeamMembers(teamMemberSet);


        this.projectRepo.save(project);



        return project;
    }

    @Override
    public Project removeTeamMember(Long teamLeadId, String teamMemberUserName, Long projectId) {
        boolean removedTeamMember=false;
//        boolean removedProject=false;
        Project project=this.projectRepo.getById(projectId);
        if(project==null){
            throw new ResourceNotFoundException("Project","Project Id",String.valueOf(projectId));
        }
        if(project.getTeamLead().getUserId()!=teamLeadId){


            return null;

        }
        Set<TeamMember> teamMemberSet=project.getTeamMembers();
        if(teamMemberSet==null){
            return null;
        }
       removedTeamMember=teamMemberSet.removeIf(teamMember -> teamMember.getUser().getUserName().equals(teamMemberUserName));

        if (!removedTeamMember){
            return null;
        }
        project.setTeamMembers(teamMemberSet);

        this.projectRepo.save(project);
//        User user=this.userRepo.getUserByUserName(teamMemberUserName);
//        List<Project> projects=user.getProjects();
//
//        removedProject=projects.remove(project);
//        if (!removedProject){
//            return null;
//        }
//        user.setProjects(projects);
//
//        this.userRepo.save(user);


        return project;
    }
}
