package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.LibraryPojo;

public interface LibraryRepository extends JpaRepository<LibraryPojo, Integer> {

}
