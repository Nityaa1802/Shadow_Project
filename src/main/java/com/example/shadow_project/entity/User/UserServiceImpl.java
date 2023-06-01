package com.example.shadow_project.entity.User;

import com.example.shadow_project.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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
}
