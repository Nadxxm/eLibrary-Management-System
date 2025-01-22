package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.UserPojo;
import com.example.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Service layer for handling user-related operations.
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Create a new user in the system.
     *
     * @param userPojo The user details to be created.
     * @return The saved user details.
     */
    public UserPojo createUsers(UserPojo userPojo) {
        log.info("Creating a new user with name: {}", userPojo.getName());
        return userRepository.save(userPojo);
    }

    /**
     * Update an existing user's details by ID.
     *
     * @param userPojo The updated user details.
     * @param id       The ID of the user to be updated.
     * @return The updated user details, or null if the user does not exist.
     */
    public UserPojo updateUsers(UserPojo userPojo, long id) {
        log.info("Attempting to update user with ID: {}", id);

        Optional<UserPojo> IdAvailable = userRepository.findById(id);

        if (IdAvailable.isPresent()) {
            UserPojo data = IdAvailable.get();
            log.info("User found. Updating details for ID: {}", id);

            // Update fields
            data.setName(userPojo.getName());
            data.setEmail(userPojo.getEmail());

            log.info("User details updated successfully for ID: {}", id);
            return userRepository.save(data);
        } else {
            log.warn("User with ID: {} not found. Update operation failed.", id);
            return null;
        }
    }

    /**
     * Retrieve all users from the system.
     *
     * @return A list of all users.
     */
    public List<UserPojo> retrieveAllUsers() {
        log.info("Retrieving all users");
        return userRepository.findAll();
    }

    /**
     * Retrieve a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user details if found, otherwise null.
     */
    @SuppressWarnings("deprecation")
	public UserPojo retrieveById(long id) {
        log.info("Retrieving user with ID: {}", id);

        Optional<UserPojo> findById = userRepository.findById(id);

        if (findById.isPresent()) {
            log.info("User with ID: {} found", id);
            return userRepository.getById(id);
        } else {
            log.warn("User with ID: {} not found", id);
            return null;
        }
    }

    /**
     * Delete a user by their ID.
     *
     * @param id The ID of the user to delete.
     * @return A message indicating the result of the delete operation.
     */
    public String deleteUser(long id) {
        log.info("Attempting to delete user with ID: {}", id);

        Optional<UserPojo> findId = userRepository.findById(id);

        if (findId.isPresent()) {
            userRepository.deleteById(id);
            log.info("User with ID: {} deleted successfully", id);
            return "User is deleted";
        } else {
            log.warn("User with ID: {} not found. Delete operation failed.", id);
            return "User is Not present";
        }
    }
}
