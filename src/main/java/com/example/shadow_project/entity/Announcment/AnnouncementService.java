package com.example.shadow_project.entity.Announcment;

import java.util.List;

public interface AnnouncementService {

    Announcement uploadAnnouncement(AnnouncementDto announcementDto);

    Announcement getAnnouncement(Long id);

    List<Announcement> top6Announcements() throws Exception;
}
