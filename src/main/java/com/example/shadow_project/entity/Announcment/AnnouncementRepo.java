package com.example.shadow_project.entity.Announcment;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnnouncementRepo extends JpaRepository<Announcement,Long> {

    @Query(value = "select a from Announcement a where a.id= :id")
    Announcement getById(@PathParam("id") Long id);
}
