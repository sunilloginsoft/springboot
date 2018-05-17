package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAuthorController {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorBookDetailsRepository authorBookDetailsRepository;
	
	@Value("${spring.profiles.active}")
	private String springActiveProfile;
	
	@RequestMapping("/getBooks")
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}
	
	@RequestMapping("/getAllAuthorBooks")
	public List<String> getAllAuthorBooks() {
		
		System.out.println(springActiveProfile);
		return authorBookDetailsRepository.getAllAuthorBooksAsString();
	}
	
	@RequestMapping("/findAuthorBooksById/{bookId}")
	public List<AuthorBookDetails> findAuthorBooksById(@PathVariable(name="bookId") Integer bookId) {
		
		System.out.println(springActiveProfile);
		return authorBookDetailsRepository.findAuthorBooksById(bookId);
	}
	
	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping("/customer")
	public void getCustomerData() {
		
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
}