package com.mongoSpringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongoSpringboot.model.Book;
import com.mongoSpringboot.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository repository;
 
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		repository.save(book);
		return "added book with id:" + book.getId();
	}

	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return repository.findAll();
	}

	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return repository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "book deleted with id:" + id;
	}

	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {
		return repository.save(book);
	}

	@GetMapping("/form")
	public String showform() {
		return "form";
	}

	@PutMapping("/   ")
	public String submitform(@RequestParam int id, @RequestParam String bookName, @RequestParam String author) {
		System.out.println("name:" + id);
		System.out.println("bookName:" + bookName);
		System.out.println("authorName:" + author);

		return "redirect:/form";

	}
}