package com.example.shadow_project.entity.Announcment;

import com.example.shadow_project.entity.Project.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    private AnnouncementServiceImpl announcementService;

    @PostMapping("/register")
    public ResponseEntity<Announcement> uploadAnnouncement(@RequestBody AnnouncementDto announcementDto){
        Announcement announcement = announcementService.uploadAnnouncement(announcementDto);
        return ResponseEntity.ok(announcement);
    }
    @GetMapping("/{announcementId}")
    public ResponseEntity<Announcement> getAnnouncement(@PathVariable("announcementId") Long id){
        Announcement announcement = announcementService.getAnnouncement(id);
        return ResponseEntity.ok(announcement);
    }
}