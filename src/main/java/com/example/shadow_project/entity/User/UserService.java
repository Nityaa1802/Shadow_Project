package com.example.shadow_project.entity.User;

public interface UserService {

    UserDto registerUser(UserDto userDto);

    UserDto loginUser(String username, String password);
}
