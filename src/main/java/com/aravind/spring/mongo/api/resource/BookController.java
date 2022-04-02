package com.aravind.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.spring.mongo.api.model.Book;
import com.aravind.spring.mongo.api.repository.BookRepository;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Book> getBookByI(@PathVariable int id) {
		return repository.findById(id);
	}

	@PostMapping()
	public Book saveBook(@RequestBody Book book) {
		repository.save(book);
		return book;
	}

	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book,@PathVariable int id) {
		Optional<Book> bookVal= repository.findById(id);
		if(bookVal.isPresent() ) {
			bookVal.get().setId(book.getId());
			bookVal.get().setAuthorName(book.getAuthorName());
            bookVal.get().setBookName(book.getBookName());
		}
		repository.save(bookVal.get());
		return bookVal.get();
	}

	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Book Deleted Successfully";
	}

}
