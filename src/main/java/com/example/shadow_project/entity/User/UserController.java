package com.example.shadow_project.entity.User;

import com.example.shadow_project.Payload.ApiResponse;
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
    public ResponseEntity<ApiResponse> registerUser(@RequestBody UserDto userDto){
        UserDto userDto1 = this.userService.registerUser(userDto);
        return new ResponseEntity<>(new ApiResponse("User Registered Successfully",true), HttpStatus.OK);
    }

    @PostMapping("/register/user")
    public ResponseEntity<UserDto> registerUser2(@RequestBody UserDto userDto){
        UserDto userDto1 = this.userService.registerUser(userDto);
        return ResponseEntity.ok(userDto1);
    }

    @GetMapping("/login/{userName}/{password}")
    public ResponseEntity<UserDto> loginUser(@PathVariable("userName") String userName , @PathVariable("password") String password){
        UserDto userDto = this.userService.loginUser(userName,password);
        return ResponseEntity.ok(userDto);
    }
}
