package com.example.shadow_project.entity.User;

import java.util.Map;

public interface UserService {

    UserResponse registerUser(UserDto userDto);

    UserResponse loginUser(String username, String password);

    UserResponse getUser(Long userId);

    UserResponse updateUserDetails(Long userId,UserDto userDto);

    Map<UserResponse,String> updatePassword(Long userId, String oldPassword , String newPassword) throws Exception;


}
