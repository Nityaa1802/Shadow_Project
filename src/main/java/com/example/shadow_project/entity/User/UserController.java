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
        System.out.println("1st");
        return new ResponseEntity<>(new ApiResponse("User Registered Successfully",true), HttpStatus.OK);
    }

    @PostMapping("/register/user")
    public ResponseEntity<UserResponse> registerUser2(@Valid @RequestBody UserDto userDto){
        UserResponse userResponse = this.userService.registerUser(userDto);
        System.out.println("2nd");




        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/login/{userName}/{password}")
    public ResponseEntity<UserResponse> loginUser(@PathVariable("userName") String userName , @PathVariable("password") String password){
        UserResponse userResponse = this.userService.loginUser(userName,password);
        System.out.println("login");
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") Long userId){
        UserResponse userResponse=this.userService.getUser(userId);
        System.out.println("3rd");
        return ResponseEntity.ok(userResponse);
    }
}
