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

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/get")
    public User getUser(@RequestParam Long id) {
        return userService.get(id);
    }

    @PutMapping("/update")
    public User updateUser(@RequestParam Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @GetMapping("/email")
    public User getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/search")
    public List<User> getUsersByNameContaining(@RequestParam String name) {
        return userService.getUsersByNameContaining(name);
    }

    @GetMapping("/gender")
    public List<User> getUsersByGender(@RequestParam String gender) {
        return userService.getUsersByGender(gender);
    }

    @PutMapping("/updateGender")
    public int updateGenderWhereNull(@RequestParam String gender) {
        return userService.updateGenderWhereNull(gender);
    }



    
}
