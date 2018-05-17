package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthorBookDetails {
	
	@Id
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AuthorBookDetails(Integer id, String book, String authorname) {
		
		this.id = id;
		this.book = book;
		this.authorName = authorname;
	}
	
	private String book;
	private String authorName;
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
