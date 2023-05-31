package com.example.shadow_project.entity.Announcment;

import com.example.shadow_project.entity.User.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "announcment")
@Data
public class Announcement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @Column(name = "isApproved")
    private boolean isApproved;
    @Column(name = "link")
    private String link;
    @Column(name = "uploadedOn")
    @CreationTimestamp
    private Date uploadedOn;

}
