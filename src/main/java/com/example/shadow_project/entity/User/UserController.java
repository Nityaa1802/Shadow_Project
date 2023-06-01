package com.example.shadow_project.entity.User;

import com.example.shadow_project.Payload.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register/response")
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody UserDto userDto){
        UserResponse userResponse = this.userService.registerUser(userDto);
        return new ResponseEntity<>(new ApiResponse("User Registered Successfully",true), HttpStatus.OK);
    }

    @PostMapping("/register/user")
    public ResponseEntity<UserResponse> registerUser2(@Valid @RequestBody UserDto userDto){
        UserResponse userResponse = this.userService.registerUser(userDto);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/login/{userName}/{password}")
    public ResponseEntity<UserResponse> loginUser(@PathVariable("userName") String userName , @PathVariable("password") String password){
        UserResponse userResponse = this.userService.loginUser(userName,password);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") Long userId){
        UserResponse userResponse=this.userService.getUser(userId);
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/updateDetails/{userId}")
    public ResponseEntity<UserResponse> updateUserDetails(@PathVariable("userId") Long userId,@Valid @RequestBody UserDto userDto) {
        UserResponse userResponse=this.userService.updateUserDetails(userId,userDto);
        return ResponseEntity.ok(userResponse);
    }
}
