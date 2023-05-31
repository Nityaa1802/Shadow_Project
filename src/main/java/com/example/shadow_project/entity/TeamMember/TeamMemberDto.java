package com.example.shadow_project.entity.TeamMember;

import lombok.Data;
import com.example.shadow_project.entity.User.User;

@Data
public class TeamMemberDto {

    private User user;

    private String role;

}
