package com.example.shadow_project.entity.User;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query(value = "select u from User u where u.userName= :userName and u.password= :password")
    User getValidUser(@PathParam("userName") String userName, @PathParam("password") String password);

    @Query(value = "select u from User u where u.userId= :userId")
    User getUser(@PathParam("userId") Long userId);

    @Query(value= "select u from User u where u.userName= :userName")
    User getUserByUserName(@PathParam("userName") String userName);
}
