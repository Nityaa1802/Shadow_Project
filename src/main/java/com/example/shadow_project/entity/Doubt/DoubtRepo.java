package com.example.shadow_project.entity.Doubt;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoubtRepo extends JpaRepository<Doubt, Long> {
    @Query(value = "select d from Doubt d where d.id= :id")
    Doubt getById(@PathParam("id") Long id);

    List<Doubt> findTop6OrderByUploadOnDesc();
}
