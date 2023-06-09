package com.example.shadow_project.entity.Announcment;

import com.example.shadow_project.entity.Project.Project;
import com.example.shadow_project.entity.Project.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/latestAnnouncements")
    public ResponseEntity<List<Announcement>> getTop6Announcements() throws Exception {
        List<Announcement> announcementList = announcementService.top6Announcements();
        return ResponseEntity.ok(announcementList);
    }
    @GetMapping("/latest30DaysAnnouncements")
    public ResponseEntity<List<Announcement>> getLatestAnnouncement() throws Exception {
        List<Announcement> announcementList = announcementService.latestAnnouncement();
        return ResponseEntity.ok(announcementList);
    }

    @GetMapping("/allAnnouncement")
    public List<Announcement> getAllAnnouncements(@RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
                                             @RequestParam(value = "pageSize",defaultValue = "5",required = false) int pageSize){
        List<Announcement> announcementList = this.announcementService.getAllAnnouncements(pageNumber,pageSize);
        return announcementList;
    }
}
