package com.example.shadow_project.entity.User;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserRepo extends JpaRepository<User,String> {

    @Query(value = "select u from User u where u.userName= :userName and u.password= :password")
    User getValidUser(@PathParam("userName") String userName, @PathParam("password") String password);

    User findUserByUserName(String userName);
}
