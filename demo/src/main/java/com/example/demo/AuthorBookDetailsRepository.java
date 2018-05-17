package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorBookDetailsRepository extends JpaRepository<AuthorBookDetails, Integer> {

	@Query(" select new com.example.demo.AuthorBookDetails(b.id, b.name, a.name) from Author a, Book b where b.author = a.id")
	//@Query(value = " select b.id, b.name, a.name into new com.example.demo.AuthorBookDetails(b.id, b.name, a.name) from authors a, books b where b.author = a.id", nativeQuery=true)
	public List<AuthorBookDetails> getAllAuthorBooks();
	
	@Query(" select b.name from Author a, Book b where b.author = a.id")
	public List<String> getAllAuthorBooksAsString();
	
	@Query(" select new com.example.demo.AuthorBookDetails(b.id, b.name, a.name) from Author a, Book b where b.author = a.id and b.id = ?1")
	public List<AuthorBookDetails> findAuthorBooksById(Integer bookId);
}
