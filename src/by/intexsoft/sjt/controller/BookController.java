package by.intexsoft.sjt.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.sjt.entity.BookEntity;
import by.intexsoft.sjt.service.BookService;
import by.intexsoft.sjt.service.BookServiceImpl;

@RestController
@RequestMapping("/book")
public class BookController {
	private static int count = 0;

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("by.intexsoft.sjt.config");
	BookService bookService = context.getBean(BookServiceImpl.class);

	@ResponseBody
	@RequestMapping("/add")
	public String add() {
		BookEntity book = new BookEntity();
		book.setAuthor("author" + count);
		book.setBook("book" + count);
		book.setUser("user" + count);
		bookService.addBook(book);
		count++;
		return "add book: " + book.getBook();
	}

	@ResponseBody
	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		List<BookEntity> rezList = bookService.findAll();
		return new ResponseEntity<List<BookEntity>>(rezList, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping("/all/del")
	public String deleteAll() {
		bookService.deleteAll();
		return "all books deleted";
	}
}
