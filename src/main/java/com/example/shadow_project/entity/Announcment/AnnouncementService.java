package com.example.shadow_project.entity.Announcment;

public interface AnnouncementService {

    Announcement uploadAnnouncement(AnnouncementDto announcementDto);

    Announcement getAnnouncement(Long id);
}
