package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.LibraryPojo;
import com.example.demo.repository.LibraryRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Service layer for handling library-related operations.
 */
@Service
@Slf4j
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    /**
     * Add a new book to the library.
     *
     * @param libraryPojo The book details to be added.
     * @return The saved book details.
     */
    public LibraryPojo addingdetails(LibraryPojo libraryPojo) {
        // Log the received data
        log.info("Received request to add book: {}", libraryPojo);
        return libraryRepository.save(libraryPojo);
    }

    /**
     * Retrieve all books from the library.
     *
     * @return List of all books in the library.
     */
    public List<LibraryPojo> retrievebooks() {
        log.info("Request received to retrieve all books.");
        return libraryRepository.findAll();
    }

    /**
     * Get a book by its ID.
     *
     * @param id The ID of the book.
     * @return The book if found, otherwise null.
     */
    public LibraryPojo getbyId(int id) {
        log.info("Request received to retrieve book with ID: {}", id);
        return libraryRepository.findById(id).orElse(null);
    }

    /**
     * Update book details by its ID.
     *
     * @param libraryPojo The updated book details.
     * @param id          The ID of the book to update.
     * @return The updated book details, or null if not found.
     */
    public LibraryPojo updatebyid(LibraryPojo libraryPojo, int id) {
        log.info("Request received to update book with ID: {}", id);
        if (libraryRepository.existsById(id)) {
            libraryPojo.setId(id);
            return libraryRepository.save(libraryPojo);
        }
        log.warn("Book with ID: {} not found for update.", id);
        return null;
    }

    /**
     * Delete a book by its ID.
     *
     * @param id The ID of the book to delete.
     * @return A message indicating the deletion status.
     */
    public String deletebyid(int id) {
        log.info("Request received to delete book with ID: {}", id);
        if (libraryRepository.existsById(id)) {
            libraryRepository.deleteById(id);
            log.info("Book with ID: {} has been deleted.", id);
            return "Book is deleted";
        }
        log.warn("Book with ID: {} not found for deletion.", id);
        return "Book Not Found";
    }
}
