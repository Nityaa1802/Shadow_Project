package com.example.shadow_project.entity.Domain;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DomainRepo extends JpaRepository<Domain,Long> {

    @Query(value = "select  d from Domain d where d.domain= :domain")
    Domain getDomain(@PathParam("domain") String domain);
    @Query(value = "select d.domain from Domain d")
    List<String> getAllDomain();
}
