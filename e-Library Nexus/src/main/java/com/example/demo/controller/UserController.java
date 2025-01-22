package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.UserPojo;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * REST Controller for managing User operations.
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Add a new user.
     *
     * @param userPojo The user details to be added.
     * @return The added user details.
     */
    @PostMapping("/add")
    public UserPojo addUser(@RequestBody UserPojo userPojo) {
        log.info("Request received to add a new user: {}", userPojo);
        return userService.createUsers(userPojo);
    }

    /**
     * Update an existing user by ID.
     *
     * @param userPojo Updated user details.
     * @param id       ID of the user to update.
     * @return The updated user details.
     */
    @PutMapping("/update/{id}")
    public UserPojo updateUser(@RequestBody UserPojo userPojo, @PathVariable long id) {
        log.info("Request received to update user with ID: {}", id);
        return userService.updateUsers(userPojo, id);
    }

    /**
     * Retrieve all users.
     *
     * @return List of all users.
     */
    @GetMapping("/retrieveAll")
    public List<UserPojo> retrieveAll() {
        log.info("Request received to retrieve all users.");
        return userService.retrieveAllUsers();
    }

    /**
     * Retrieve a user by ID.
     *
     * @param id ID of the user to retrieve.
     * @return The user details if found.
     */
    @GetMapping("/retrievebyId/{id}")
    public UserPojo retrieveById(@PathVariable long id) {
        log.info("Request received to retrieve user with ID: {}", id);
        return userService.retrieveById(id);
    }

    /**
     * Delete a user by ID.
     *
     * @param id ID of the user to delete.
     * @return A message indicating the deletion status.
     */
    @DeleteMapping("/deletebyId/{id}")
    public String deleteById(@PathVariable long id) {
        log.info("Request received to delete user with ID: {}", id);
        return userService.deleteUser(id);
    }
}
