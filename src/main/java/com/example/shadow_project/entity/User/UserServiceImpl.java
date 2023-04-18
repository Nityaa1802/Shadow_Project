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
    public UserDto registerUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);
        User savedUser = this.userRepo.save(user);
        UserDto savedUserDto = this.modelMapper.map(savedUser, UserDto.class);
        return savedUserDto;
    }

    @Override
    public UserDto loginUser(String userName, String password) {

        User user = this.userRepo.getValidUser(userName,password);
        if(user==null){
            throw new ResourceNotFoundException("User","userName",userName);
        }
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
