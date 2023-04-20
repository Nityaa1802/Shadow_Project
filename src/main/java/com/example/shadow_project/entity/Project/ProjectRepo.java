package com.example.shadow_project.entity.Project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;


public interface ProjectRepo extends JpaRepository<Project,Long> {
//    Page<Project> findByCompleted(@RequestParam("completed") boolean completed, Pageable pageable);

    Page<Project> findByCompletedIsTrue(Pageable pageable);
}
