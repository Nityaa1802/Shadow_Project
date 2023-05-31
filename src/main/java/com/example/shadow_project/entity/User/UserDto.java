package com.example.shadow_project.entity.User;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.*;


@Data
public class UserDto {
    @NotEmpty
    @Size(min = 4 , message = "Username must be min of 4 characters !!")
    private String userName;
    @NotEmpty
    private String name;
    @Email(message = "Email address is not valid !!")
    private String email;
    @NotEmpty
    @Size(min = 6 , max = 15 , message = "Password must be min of 6 chars and max of 15 chars ")
    private String password;
    @NotEmpty
    @Size(min=1,max=10,message = "You should input at least 1 skill  ")
    List<String> skills=new ArrayList<>();



}
