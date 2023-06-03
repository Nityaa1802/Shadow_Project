package com.example.shadow_project.entity.User;

public interface UserService {

    UserResponse registerUser(UserDto userDto);

    UserResponse loginUser(String username, String password);

    UserResponse getUser(Long userId);

    UserResponse updateUserDetails(Long userId,UserDto userDto);


}
