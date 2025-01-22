package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.BookPojo;

public interface BookRepository extends JpaRepository<BookPojo, Long>{

}
