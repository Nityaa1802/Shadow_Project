package com.example.shadow_project.entity.Announcment;

import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;

public interface AnnouncementRepo extends JpaRepository<Announcement,Long> {

    Page<Announcement> findAll(Pageable pageable);

    @Query(value = "select a from Announcement a where a.id= :id")
    Announcement getById(@PathParam("id") Long id);


}
