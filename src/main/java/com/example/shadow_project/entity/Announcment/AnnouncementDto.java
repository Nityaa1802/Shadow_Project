package com.example.shadow_project.entity.Announcment;

import com.example.shadow_project.entity.User.User;
import lombok.Data;

@Data
public class AnnouncementDto {

    private Long id;
    private String title;
    private String description;
    private boolean isApproved;
    private String owner;
    private String link;
    private String img;
}
