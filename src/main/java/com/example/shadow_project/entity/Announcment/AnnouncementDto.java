package com.example.shadow_project.entity.Announcment;

import com.example.shadow_project.entity.User.User;
import lombok.Data;

@Data
public class AnnouncementDto {
    private String title;
    private String description;
    private boolean isApproved;
    private User owner;
    private String link;

}
