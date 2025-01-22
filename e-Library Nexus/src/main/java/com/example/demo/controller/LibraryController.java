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

import com.example.demo.pojo.LibraryPojo;
import com.example.demo.service.LibraryService;

import lombok.extern.slf4j.Slf4j;

/**
 * REST Controller for managing Library operations.
 */
@RestController
@RequestMapping("/library")
@Slf4j
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    /**
     * Add a new book to the library.
     *
     * @param libraryPojo The book details to be added.
     * @return The added book details.
     */
    @PostMapping("/add")
    public LibraryPojo Addingbooks(@RequestBody LibraryPojo libraryPojo) {
        // Log the request body
        log.info("Received request to add a book: {}", libraryPojo);
        return libraryService.addingdetails(libraryPojo);
    }

    /**
     * Retrieve all books from the library.
     *
     * @return List of all books in the library.
     */
    @GetMapping("/retrieve")
    public List<LibraryPojo> retrieving() {
        log.info("Request received to retrieve all books.");
        return libraryService.retrievebooks();
    }

    /**
     * Retrieve a book by its ID.
     *
     * @param id The ID of the book to retrieve.
     * @return The book details if found.
     */
    @GetMapping("/retrievebyId/{id}")
    public LibraryPojo retrievebyId(@PathVariable int id) {
        log.info("Request received to retrieve book with ID: {}", id);
        return libraryService.getbyId(id);
    }

    /**
     * Update the details of a book by its ID.
     *
     * @param libraryPojo The updated book details.
     * @param id          The ID of the book to update.
     * @return The updated book details.
     */
    @PutMapping("/update/{id}")
    public LibraryPojo updateId(@RequestBody LibraryPojo libraryPojo, @PathVariable int id) {
        log.info("Request received to update book with ID: {}", id);
        return libraryService.updatebyid(libraryPojo, id);
    }

    /**
     * Delete a book by its ID.
     *
     * @param id The ID of the book to delete.
     * @return A message indicating the deletion status.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteId(@PathVariable int id) {
        log.info("Request received to delete book with ID: {}", id);
        return libraryService.deletebyid(id);
    }
}
