package com.example.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Librarydb")
public class LibraryPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String title;
	private String author;
    private boolean available;
}
