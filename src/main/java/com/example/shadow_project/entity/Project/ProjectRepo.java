package com.example.shadow_project.entity.Project;

import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProjectRepo extends JpaRepository<Project,Long> {
//    Page<Project> findByCompleted(@RequestParam("completed") boolean completed, Pageable pageable);

    Page<Project> findByCompletedIsTrue(Pageable pageable);

    @Query(value = "select  p from Project p where p.id= :id")
    Project getById(@PathParam("id") Long id);
}
