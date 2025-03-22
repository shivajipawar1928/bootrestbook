package com.api.book.bootrestbook.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookServices {
	
	static List<Book> list=new ArrayList<Book>();
	
	static{
		list.add(new Book(1,"Complete Java","Xyz"));
		list.add(new Book(2,"Complete Angular","Abc"));
		list.add(new Book(3,"Complete SQl","Lmn"));
		list.add(new Book(4,"Complete Aws","Pqr"));
	}
	
	public List<Book> getAllBooks() {
		return list;
	}
	
	public Book getBook(int bid) {
		Book book=new Book();
		for(Book b:list) {
			if(b.getId()==bid) {
				book=b;
			}
		}
		return book;
	}

	public Book addNewBook(Book book) {
		list.add(book);
		return book;
	}

	public List deleteBook(int id) {
		List<Book> list1=list;
		list=new ArrayList<Book>();
		
		for(Book b:list1) {
			
			if(b.getId()!=id) {
				list.add(new Book(b.getId(),b.getTitle(),b.getAuthor()));
			}
		}
		return list;
	}

	public Book updateBook(Book book, int id) {
		Book UpdatedBook=null;
		for(Book b:list) {
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
				UpdatedBook=b;
			}
			
		}
		return UpdatedBook;
	}
	
	
	
	
}
