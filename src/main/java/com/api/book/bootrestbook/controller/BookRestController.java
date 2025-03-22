package com.api.book.bootrestbook.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.book.bootrestbook.model.Book;
import com.api.book.bootrestbook.model.BookServices;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class BookRestController {
	
	@Autowired
	private BookServices bookServices;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookServices.getAllBooks();
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable("bookId") int id) {
		return this.bookServices.getBook(id);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return this.bookServices.addNewBook(book);
	}
	
	@DeleteMapping("/books/{bookId}")
	public List delete(@PathVariable("bookId") int id) {
		return this.bookServices.deleteBook(id);
	}
	
	@PutMapping("/books/{bookId}")
	public Book update(@RequestBody Book book, @PathVariable("bookId") int id) {
		return this.bookServices.updateBook(book,id);
	}

	
	
}
