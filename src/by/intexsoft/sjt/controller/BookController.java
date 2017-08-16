package by.intexsoft.sjt.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.sjt.entity.BoardEntity;
import by.intexsoft.sjt.entity.BookEntity;
import by.intexsoft.sjt.service.BookService;
import by.intexsoft.sjt.service.impl.BookServiceImpl;

@RestController
@RequestMapping("/book")
public class BookController {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("by.intexsoft.sjt.config");
	BookService bookService = context.getBean(BookServiceImpl.class);

	@RequestMapping("/add/{tittle}/{author}")
	public ResponseEntity<?> add(@PathVariable("tittle") String tittle, @PathVariable("author") String author) {
		BookEntity book = new BookEntity();
		book.author = author;
		book.tittle = tittle;
		return new ResponseEntity<BookEntity>(bookService.save(book), HttpStatus.OK);
	}

	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<BookEntity>>(bookService.findAll(), HttpStatus.OK);
	}

	@RequestMapping("/all/del")
	public String deleteAll() {
		bookService.deleteAll();
		return "all books deleted";
	}

	@RequestMapping("/del/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		BookEntity entity = bookService.deleteById(id);
		if (!entity.equals(null)) {
			return "book with id=" + entity.getId() + "deleted";
		}
		return "book with id=" + id + " is not exist";
	}

	@RequestMapping("/board/{bookId}")
	public ResponseEntity<?> getBoard(@PathVariable("bookId") Long bookId) {
		BookEntity book = bookService.findById(bookId);
		return new ResponseEntity<BoardEntity>(book.board, HttpStatus.OK);
	}

	@RequestMapping("findT/{title}")
	public ResponseEntity<?> findByTitle(@PathVariable("title") String title) {
		List<BookEntity> rezList = bookService.findByTittle(title);
		return new ResponseEntity<List<BookEntity>>(rezList, HttpStatus.OK);
	}
}
