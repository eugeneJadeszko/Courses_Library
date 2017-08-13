package by.intexsoft.sjt.service;

import java.util.List;

import by.intexsoft.sjt.entity.BookEntity;

public interface BookService {
	BookEntity addBook(BookEntity book);

	List<BookEntity> findAll();
	
	void deleteAll();
}
