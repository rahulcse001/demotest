package com.demo.dsl.dashboard.dlo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.dsl.dashboard.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
	
	

}
