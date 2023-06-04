package com.example.shadow_project.entity.User;

import com.example.shadow_project.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserResponse registerUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);
        User savedUser = this.userRepo.save(user);
        UserResponse savedUserResponse = this.modelMapper.map(savedUser, UserResponse.class);
        return savedUserResponse;
    }

    @Override
    public UserResponse loginUser(String userName, String password) {

        User user = this.userRepo.getValidUser(userName,password);
        if(user==null){
            throw new ResourceNotFoundException("User","userName",userName);
        }
        UserResponse userResponse = this.modelMapper.map(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public UserResponse getUser(Long userId) {
        User user=this.userRepo.getUser(userId);
        if(user==null){
            throw new ResourceNotFoundException("User","userId",String.valueOf(userId));
        }
        UserResponse userResponse=this.modelMapper.map(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public UserResponse updateUserDetails(Long userId, UserDto userDto) {
        User user=this.userRepo.getUser(userId);

        // I think this should not be here
        if (user==null){
            throw new ResourceNotFoundException("User","userId",String.valueOf(userId));
        }
        user.setUserName(userDto.getUserName());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setLinkedIn(userDto.getLinkedIn());
        user.setSkills(userDto.getSkills());
        this.userRepo.save(user);
        UserResponse userResponse=this.modelMapper.map(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public Map<UserResponse,String> updatePassword(Long userId, String oldPassword , String newPassword) throws Exception {
        User user = this.userRepo.getUser(userId);
        if(oldPassword != user.getPassword()){
            throw new Exception("Password dosen't match please enter the correct Password");
        }
        User user1 = this.userRepo.updatePassword(newPassword,userId);
        UserResponse userResponse = this.modelMapper.map(user1, UserResponse.class);
        Map<UserResponse,String> result = new HashMap<>();
        result.put(userResponse,"Your Password has been updated to : "+newPassword);
        return result;
    }
}
