package com.example.shadow_project.entity.Announcment;

import com.example.shadow_project.entity.Project.Project;

import java.util.List;

public interface AnnouncementService {

    Announcement uploadAnnouncement(AnnouncementDto announcementDto);

    Announcement getAnnouncement(Long id);

    List<Announcement> top6Announcements() throws Exception;

    List<Announcement> latestAnnouncement() throws Exception;

    List<Announcement> getAllAnnouncements(int pageNumber, int pageSize);
}
