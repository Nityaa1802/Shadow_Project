package com.example.shadow_project.entity.User;

import com.example.shadow_project.entity.Project.Project;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query(value = "select u from User u where u.userName= :userName and u.password= :password")
    User getValidUser(@PathParam("userName") String userName, @PathParam("password") String password);

    @Query(value = "select u from User u where u.userId= :userId")
    User getUser(@PathParam("userId") Long userId);

    @Query(value= "select u from User u where u.userName= :userName")
    User getUserByUserName(@PathParam("userName") String userName);

    @Modifying
    @Query(value = "update User u set u.password = :newPassword where u.userId = :userId")
    int updatePassword(@PathParam("newPassword") String newPassword, @PathParam("userId") Long userId);

    List<Object> findAllByNameContainingIgnoreCase(String input);
}
