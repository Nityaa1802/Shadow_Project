package com.example.shadow_project.entity.Project;

import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProjectRepo extends JpaRepository<Project,Long> {
//    Page<Project> findByCompleted(@RequestParam("completed") boolean completed, Pageable pageable);

    Page<Project> findByIsCompletedIsTrue(Pageable pageable);

    @Query(value = "select  p from Project p where p.id= :id")
    Project getById(@PathParam("id") Long id);

    @Query(value = "select p from Project p join p.teamMembers.user.userName u where u= :userName")
    List<Project> getProjectsByTeamMember(@PathParam("userName")String userName);



    @Query(value = "select p from Project p where p.teamLead.userName= :teamLead")
    List<Project> getProjectsByTeamLead(@PathParam("teamLead") String teamLead);



    List<Object> findAllByProjectNameContainingIgnoreCase(String input);

}
