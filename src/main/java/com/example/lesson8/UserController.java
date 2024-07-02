package com.example.lesson8;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
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
}
