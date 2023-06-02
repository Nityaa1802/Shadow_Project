package com.example.shadow_project.entity.Announcment;

import ch.qos.logback.core.model.Model;
import com.example.shadow_project.entity.Project.Project;
import com.example.shadow_project.entity.Project.ProjectDto;
import com.example.shadow_project.entity.User.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{
    @Autowired
    private AnnouncementRepo announcementRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

    @Override
    public Announcement uploadAnnouncement(AnnouncementDto announcementDto) {
        modelMapper.typeMap(AnnouncementDto.class, Announcement.class).addMappings(
                mapper-> mapper.map(announcementDto1->userRepo.getUserByUserName(announcementDto.getOwner()),Announcement::setOwner)
        );

        Announcement announcement = modelMapper.map(announcementDto,Announcement.class);
        Announcement savedAnnouncement = announcementRepo.save(announcement);

        return savedAnnouncement;
    }

    @Override
    public Announcement getAnnouncement(Long id) {
        Announcement announcement = announcementRepo.getById(id);
        return announcement;
    }
}
