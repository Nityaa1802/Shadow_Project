package com.example.shadow_project.entity.general;

import com.example.shadow_project.entity.Announcment.Announcement;
import com.example.shadow_project.entity.Announcment.AnnouncementRepo;
import com.example.shadow_project.entity.Doubt.Doubt;
import com.example.shadow_project.entity.Doubt.DoubtRepo;
import com.example.shadow_project.entity.Project.Project;
import com.example.shadow_project.entity.Project.ProjectRepo;
import com.example.shadow_project.entity.User.User;
import com.example.shadow_project.entity.User.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class GeneralServiceImpl implements GeneralService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    AnnouncementRepo announcementRepo;
    @Autowired
    DoubtRepo doubtRepo;


    @Override
    public Map<String, List<Object>> searchAll(String input) {
        Map<String,List<Object>> map=new HashMap<>();

        List<Object> userList=this.userRepo.findAllByNameContainingIgnoreCase(input);
        List<Object> projectList= this.projectRepo.findAllByProjectNameContainingIgnoreCase(input);
        List<Object> announcementList=this.announcementRepo.findAllByTitleContainingIgnoreCase(input);
        List<Object> doubtList=this.doubtRepo.findAllByQuestionContainingIgnoreCase(input);
        map.put("Users",userList);
        map.put("Projects",projectList);
        map.put("Announcements",announcementList);
        map.put("Doubts",doubtList);
        return map;

    }
}
