package com.example.shadow_project.entity.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "domain")
public class Domain {
    @Id
    @Column(name = "domainId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long domainId;
    @Column(name = "domain")
    String domain;

    @ElementCollection
    @Column(name = "listOfProjects")
    List<Long> projectsInDomain;
}
