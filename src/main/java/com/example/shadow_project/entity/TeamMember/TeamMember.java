package com.example.shadow_project.entity.TeamMember;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.example.shadow_project.entity.User.User;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class TeamMember {

    @OneToOne
    private User user;

    private String role;

}
