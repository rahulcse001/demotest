package com.demo.dsl.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.demo.dsl.dashboard.dlo.BookRepo;
import com.demo.dsl.dashboard.model.Book;

@Component
public class BookService {

	@Autowired
	BookRepo repo;

	public List<Book> getAllbooks() {

		List<Book> booklist = repo.findAll();

		// booklist.forEach(book-> {System.out.println(book);});

		return booklist;
	}

	public Book getBookBaseOnId(int id) {

		Book book = null;

		try {

			book = repo.findById(id).get();

		} catch (Exception e) {

			e.printStackTrace();
			
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

		return null;

	}

}
