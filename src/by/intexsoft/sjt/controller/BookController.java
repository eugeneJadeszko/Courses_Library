package by.intexsoft.sjt.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.sjt.entity.BookEntity;
import by.intexsoft.sjt.service.BookService;
import by.intexsoft.sjt.service.impl.BookServiceImpl;

@RestController
@RequestMapping("/book")
public class BookController {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("by.intexsoft.sjt.config");
	BookService bookService = context.getBean(BookServiceImpl.class);

	@RequestMapping("/add/{tittle}/{author}/{user}")
	public ResponseEntity<?> add(@PathVariable("tittle") String tittle, @PathVariable("author") String author,
			@PathVariable("user") String user) {
		BookEntity book = new BookEntity();
		book.author = author;
		book.book = tittle;
		book.user = user;
		return new ResponseEntity<BookEntity>(bookService.save(book), HttpStatus.OK);
	}

	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		List<BookEntity> rezList = bookService.findAll();
		return new ResponseEntity<List<BookEntity>>(rezList, HttpStatus.OK);
	}

	@RequestMapping("/all/del")
	public String deleteAll() {
		bookService.deleteAll();
		return "all books deleted";
	}

	@RequestMapping("/find/{id}")
	public String findById(@PathVariable("id") Long id) {
		return "id: " + bookService.findById(id).getId() + ", tittle: " + bookService.findById(id).book + ", author: "
				+ bookService.findById(id).author;
	}

	@RequestMapping("/del/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		BookEntity entity = bookService.deleteById(id);
		if (!entity.equals(null)) {
			return "book with id=" + entity.getId() + "deleted";
		}
		return "book with id=" + id + " is not exist";
	}
}
