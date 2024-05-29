package com.aos.curriculum.controller;

import com.aos.curriculum.model.UserCv;
import com.aos.curriculum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserCv createUser(@RequestBody UserCv userCv) {
        return userService.createUser(userCv);
    }

    @GetMapping
    public List<UserCv> getUsers() {
        return userService.retrieveUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserCv> getUser(@PathVariable UUID id) {
        return userService.retrieveUserById(id);
    }

    @PutMapping("/{id}")
    public Optional<UserCv> updateUser(@PathVariable UUID id, @RequestBody UserCv userCv) {
        return userService.updateUser(id, userCv);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable UUID id) {
        return userService.deleteUser(id);
    }
}