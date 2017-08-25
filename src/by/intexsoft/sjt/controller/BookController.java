package by.intexsoft.sjt.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.sjt.entity.BoardEntity;
import by.intexsoft.sjt.entity.BookEntity;
import by.intexsoft.sjt.service.BookService;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/book")
public class BookController {
	private static Logger logger = (Logger) LoggerFactory.getLogger(BookController.class.getName());

	@Autowired
	BookService bookService;

	@RequestMapping("/add/{title}/{author}")
	public ResponseEntity<?> add(@PathVariable("title") String title, @PathVariable("author") String author) {
		logger.info("Creation of a new book with the name: " + title + " and author: " + author);
		BookEntity book = new BookEntity();
		book.author = author;
		book.tittle = title;
		try {
			return new ResponseEntity<BookEntity>(bookService.save(book), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error while saving new book with title: " + title + " and author: " + author);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		logger.info("Getting all books");
		return new ResponseEntity<List<BookEntity>>(bookService.findAll(), HttpStatus.OK);
	}

	@RequestMapping("/all/del")
	public ResponseEntity<?> deleteAll() {
		logger.info("Delete all books");
		try {
			bookService.deleteAll();
		} catch (Exception e) {
			logger.error("Error while deleting all books");
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/del/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		logger.info("Delete book with id= " + id);
		BookEntity book;
		try {
			book = bookService.deleteById(id);
		} catch (Exception e) {
			logger.error("book with id= " + id + " is not exist");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@RequestMapping("/board/{bookId}")
	public ResponseEntity<?> getBoard(@PathVariable("bookId") Long bookId) {
		BookEntity book = bookService.findById(bookId);
		return new ResponseEntity<BoardEntity>(book.board, HttpStatus.OK);
	}

	@RequestMapping("findT/{title}")
	public ResponseEntity<?> findByTitle(@PathVariable("title") String title) {
		logger.info("Getting books with title: " + title);
		List<BookEntity> rezList = bookService.findByTittle(title);
		if (rezList.isEmpty()) {
			logger.info("Books with the title: " + title + " not found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BookEntity>>(rezList, HttpStatus.OK);
	}
}
