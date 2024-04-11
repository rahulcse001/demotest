package com.demo.dsl.dashboard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dsl.dashboard.model.Book;
import com.demo.dsl.dashboard.service.BookService;

@RestController
public class DemoTest {

	@Autowired
	BookService service;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllbooks() {
		try {
			List<Book> list = service.getAllbooks();

			if (list.size() <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			} else {

				return ResponseEntity.of(Optional.of(list));
			}
		} catch (Exception e) {

			e.printStackTrace();

			return (ResponseEntity<List<Book>>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookId(@PathVariable int id)
	{
	
		Book book= service.getBookBaseOnId(id);
		
		if(book ==null)
		{
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
		
	}

}
