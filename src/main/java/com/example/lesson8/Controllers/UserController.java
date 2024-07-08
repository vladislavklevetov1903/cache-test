package com.example.lesson8.Controllers;


import com.example.lesson8.Entities.User;
import com.example.lesson8.ServicesInterfaces.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "Working with the BD 'users'")
@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @Operation(summary = "Create User")
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @Operation(summary = "Search User by Id")
    @GetMapping("/get")
    public User getUser(@RequestParam Long id) {
        return userService.get(id);
    }

    @Operation(summary = "Update User")
    @PutMapping("/update")
    public User updateUser(@RequestParam Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @Operation(summary = "Search User by Email")
    @GetMapping("/email")
    public User getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @Operation(summary = "Search User by Name")
    @GetMapping("/search")
    public List<User> getUsersByNameContaining(@RequestParam String name) {
        return userService.getUsersByNameContaining(name);
    }

    @Operation(summary = "Search Users by Gender")
    @GetMapping("/gender")
    public List<User> getUsersByGender(@RequestParam String gender) {
        return userService.getUsersByGender(gender);
    }

    @Operation(summary = "Update Gender where is null")
    @PutMapping("/updateGender")
    public int updateGenderWhereNull(@RequestParam String gender) {
        return userService.updateGenderWhereNull(gender);
    }



    
}
